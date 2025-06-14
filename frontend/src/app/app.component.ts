import { Component } from '@angular/core';
import { HttpClient, HttpEventType } from '@angular/common/http';

interface StoredFile {
  id: number;
  filename: string;
  url: string;
  summary: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  selectedFile?: File;
  urlInput = '';
  files: StoredFile[] = [];
  uploading = false;

  constructor(private http: HttpClient) {
    this.loadFiles();
  }

  onFileSelected(event: Event) {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      this.selectedFile = input.files[0];
    }
  }

  upload() {
    if (!this.selectedFile) return;
    const formData = new FormData();
    formData.append('file', this.selectedFile);
    this.uploading = true;
    this.http.post<StoredFile>('/api/files', formData, {
      reportProgress: true,
      observe: 'events'
    }).subscribe(event => {
      if (event.type === HttpEventType.Response) {
        this.files.push(event.body as StoredFile);
        this.uploading = false;
      }
    });
  }

  addUrl() {
    if (!this.urlInput) return;
    this.uploading = true;
    this.http.post<StoredFile>('/api/files/url?url=' + encodeURIComponent(this.urlInput), {})
      .subscribe(res => {
        this.files.push(res);
        this.urlInput = '';
        this.uploading = false;
      });
  }

  loadFiles() {
    this.http.get<StoredFile[]>('/api/files').subscribe(data => this.files = data);
  }
}
