# Aitool

This repository provides a minimal full-stack example using **Spring Boot** for the backend and **Angular** for the frontend. The environment does not have internet access, so Maven and npm dependencies must be provided offline.

## Backend

The backend project lives in the `backend` directory. Copy a Maven distribution to `./maven` and populate `offline-maven-repo` with the required artifacts. Then run:

```bash
./setup-backend.sh
```

This starts a Spring Boot application that exposes REST endpoints for uploading files or referencing remote URLs. Uploaded files are summarized asynchronously (OpenAI integration is left as a TODO).

## Frontend

The Angular project resides under `frontend`. Provide a pre-downloaded `node_modules` directory or use a local npm cache so that dependencies resolve offline. Once prepared, you can run the tests or start the dev server:

```bash
./setup-frontend.sh    # run Angular unit tests
cd frontend
npm start              # launch the development server
```

The dev server expects the backend to be running on `localhost:8080`.

## Structure

- `backend` – Spring Boot application
- `frontend` – Angular application
