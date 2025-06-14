#!/bin/sh
# Placeholder setup for backend
# Copy your offline Maven distribution to ./maven before running

if [ ! -x "./maven/bin/mvn" ]; then
  echo "Maven distribution missing. Copy it to ./maven" >&2
  exit 1
fi

./mvnw -Dmaven.repo.local=./offline-maven-repo -q test
