#!/usr/bin/env bash

if [[ -z "$1" ]]
then
  echo "Please provide a docker registry server."
  exit 1
fi

if [[ -z "$2" ]]
then
  echo "Please provide a version for the container."
  exit 1
fi

REGISTRY="$1"
VERSION="$2"
BASE_IMAGE="$3"

if [[ -z "$BASE_IMAGE" ]]
then
    BASE_IMAGE="ubuntu:focal"
fi

echo ">> Base image: $BASE_IMAGE"
docker build --no-cache --build-arg BASE_IMAGE=$BASE_IMAGE --tag "$REGISTRY:$VERSION" --file Dockerfile .
docker tag "$REGISTRY:$VERSION" "$REGISTRY:latest"

