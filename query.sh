#!/bin/bash

# default values
DEBUG=""
SPEED=""
RESULT_SIZE=""


# optional arguments
while getopts "dh:-:" opt; do
  case "${opt}" in
    d)
      DEBUG="true"
      ;;
    h)
      echo "Usage: hw3.sh [OPTIONS] QUERY"
      echo "Example: hw3.sh --speed=2 --result-size=50 france paris wine bread"
      echo "Options:"
      echo "  -d            Enable debug mode"
      echo "  --speed       Set speed factor [1 - 3], higher speeds use more memory"
      echo "  --result-size Set the number of results returned"
      exit 0
      ;;
    -)
      case "${OPTARG}" in
        speed=*)
          SPEED="${OPTARG#*=}"
          ;;
        result-size=*)
          RESULT_SIZE="${OPTARG#*=}"
          ;;
        *)
          echo "Invalid option: --${OPTARG}"
          exit 1
          ;;
      esack
      ;;
    \?)
      echo "Invalid option: -$OPTARG"
      exit 1
      ;;
  esac
done
shift $((OPTIND -1))

java_args=""
if [[ ! -z $DEBUG ]]; then
  java_args="$java_args -debug"
fi
if [[ ! -z $SPEED ]]; then
  java_args="$java_args -speed=$SPEED"
fi
if [[ ! -z $RESULT_SIZE ]]; then
  java_args="$java_args -result-size=$RESULT_SIZE"
fi
search_terms=""
for var in "$@"
do
    search_terms="$search_terms $var"
done

time (java -jar target/hw4-2-spring-boot.jar query $java_args $search_terms)
