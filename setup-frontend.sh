#!/bin/sh
# Placeholder setup for frontend
# Ensure node_modules contains jest before running

if [ ! -d "frontend/node_modules/jest" ]; then
  echo "Missing node_modules. Populate them before running." >&2
  exit 1
fi

cd frontend && npm test --silent
