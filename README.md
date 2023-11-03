# Build Your Own Search Engine

### To Run:

  - `chmod 700 ./hw3.sh`
  - `./hw3.sh [OPTIONS] input-directory output-directory`

  - `input-directory` is the input file containing the .html webpages you wish to tokenize
  - `output-directory` will hold temporary files created during the tokenization process

### Description

Parse and tokenize an entire directory of webpages. Turn those tokens into an **Inverted File**. Provide a search query, e.g. 'october launch schedule'.
The Inverted File will be searched, and the top matching documents will be provided.

### Timings

These are just so you have a rough idea how long an operation might take. If you have 1,750,000 documents, it could easily take 125 minutes to index. 

On a 2022 Macbook Air 8GB memory: 

  - 1750 files: 7.5 seconds

On a 2020 Lenova Thinkpad 8GB memory:

  - 1750 files: 13.5 seconds

### Objective

Learn about search engines, Antlr4, and concurrency for IO operations. 
