#!/bin/sh
# Simple Maven wrapper placeholder
if [ -x "$(dirname "$0")/maven/bin/mvn" ]; then
  MAVEN="$(dirname "$0")/maven/bin/mvn"
else
  MAVEN=mvn
fi
exec "$MAVEN" "$@"
