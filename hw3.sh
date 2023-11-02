#!/bin/bash

echo "Franklin True Martin HW4 part 1"
echo "This project is created using Antlr4 as the Lexer/Parser, \\
Multi-Way Merge Method to build the inverted file, \\
and TF*IDF for the weights. Query comparissions will be done \\
using the Vector-Space method. At the end of the program \\
the inverted file contents will be output. Temporary files \\
can be removed with the [-c] OPTION. Use [-h] for more options."

# default values
DEBUG=""
CLEAR="false"
BUFFER_SIZE=""
DHT_SIZE=""
GHT_SIZE=""

# optional arguments
while getopts ":d:h:-:" opt; do
  case $opt in
    d)
      DEBUG="true"
      ;;
    c)
      CLEAR="true"
      ;;
    h)
      echo "Usage: hw3.sh [OPTIONS] INPUT_DIR OUTPUT_DIR"
      echo "Options:"
      echo "  -d            Enable debug mode"
      echo "  --buffer-size Set the BufferReader size in bytes"
      echo "  --dht-size    Set the document hash table max buckets"
      echo "  --ght-size    Set the global hash table max buckets"
      exit 0
      ;;
    -)
      case "${OPTARG}" in
        buffer-size=*)
          BUFFER_SIZE="${OPTARG#*=}"
          ;;
        dht-size=*)
          DHT_SIZE="${OPTARG#*=}"
          ;;
        ght-size=*)
          GHT_SIZE="${OPTARG#*=}"
          ;;
        *)
          echo "Invalid option: --${OPTARG}"
          exit 1
          ;;
      esac
      ;;
    \?)
      echo "Invalid option: -$OPTARG"
      exit 1
      ;;
  esac
done
shift $((OPTIND -1))

# mandatory arguments
if [[ -z $2 ]] || [[ -z  $1 ]]; then
  echo "Invalid input. Enter the input and output directories as arg1 and arg2"
  exit 2
fi

echo "Creating output directory if not already present"
mkdir $2 2>/dev/null
java_args=""
if [[ ! -z $DEBUG ]]; then
  java_args="$java_args -debug"
fi
if [[ ! -z $BUFFER_SIZE ]]; then
  java_args="$java_args -buffer-size=$BUFFER_SIZE"
fi
if [[ ! -z $DHT_SIZE ]]; then
  java_args="$java_args -dht-size=$DHT_SIZE"
fi
if [[ ! -z $GHT_SIZE ]]; then
  java_args="$java_args -ght-size=$GHT_SIZE"
fi

time (java -jar target/hw4-1-spring-boot.jar $1 $2 $java_args)
if [[ ! -z $GHT_SIZE ]]; then
  java_args="$java_args -ght-size=$GHT_SIZE"
fi

if [[ "$CLEAR" == "true" ]]; then
  echo "Clearing temporary files"
  rm -rd $2
else
  echo "Complete, temporary files in: $2"
  echo "Map, Dict, and Post are in $(pwd)"
fi
