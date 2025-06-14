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
