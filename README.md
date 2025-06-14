# aitool

This repository provides a minimal demonstration of a backend written in Spring Boot and a frontend using Node with Jest for testing. The environment lacks internet access, so you must provide dependencies offline.

## Backend

A simple Spring Boot application lives in the `backend` directory. Copy a Maven distribution to `./maven` and populate `offline-maven-repo` with the required artifacts. Then run:

```bash
./setup-backend.sh
```

## Frontend

The `frontend` directory holds a small Node project with Jest. Place a pre-downloaded `node_modules` directory under `frontend/` or fill it using a local npm cache. Tests can then run with:

```bash
./setup-frontend.sh
```
=======
# Aitool

This repository contains a minimal example of a full-stack application built with **Spring Boot** and **Angular**. The backend exposes REST endpoints for uploading files or referencing files by S3 URL. Uploaded files are summarized asynchronously using a Retrieval Augmented Generation (RAG) approach (the actual OpenAI integration is left as a TODO). The frontend provides a simple Angular interface to upload files, add remote URLs and display summaries.

## Structure

- `backend` – Spring Boot application
- `frontend` – Angular application

## Running Backend

The backend uses Maven. Java 21 is required.

```bash
cd backend
mvn spring-boot:run
```

## Running Frontend

Install dependencies with npm and start the development server:

```bash
cd frontend
npm install
npm start
```

The Angular dev server expects the backend to run on `localhost:8080`.
