#!/usr/bin/env bash

git submodule update --init --recursive

# Directory where JavaBHV is located
JAVA_BHV_DIR="JavaBHV"

# Navigate to the JavaBHV directory
cd "$JAVA_BHV_DIR"

# 1. Build the C++ code
cd c-src
./build.sh
cd ..

# 2. Compile the Java code
${JAVA_HOME}/bin/javac -d . src/BHV.java
cp BHV.class ../resources/

# Detect operating system and copy the necessary shared library to resources
OS_NAME=$(uname -s)

if [ "$OS_NAME" == "Darwin" ]; then
    cp c-src/libBHV.dylib ../resources/
elif [ "$OS_NAME" == "Linux" ]; then
    cp c-src/libBHV.so ../resources/
else
    echo "Unsupported OS"
    exit 1
fi
