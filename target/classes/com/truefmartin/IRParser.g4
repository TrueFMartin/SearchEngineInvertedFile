parser grammar IRParser;

options {
    tokenVocab = IRLexer;
}

// Define parser rules for your language
document
    : html+ EOF
    ;

html
    : (tagStart | noTagStart)? NEW_LINE+
    ;

tagStart
    : TAG_START+ tag
    | internalTag+? (outOfTag | TAG_END)*?
    ;

tag
    : outOfTag*? TAG_END*? outOfTag*?
    ;

noTagStart
    : outOfTag+ TAG_END*?
    | TAG_END+
    ;

outOfTag
    : outOfTagClean
    | outOfTagDirty
    | handleInteger
    ;

outOfTagDirty
    : TEXT_WITH_PUNCUATION
    ;

outOfTagClean
    : PLAIN_TEXT
    | EMAIL
    | URL
    ;

internalTag
    : TAG_START_OPEN contentText? TAG_START_CLOSE
    ;

contentText
    : CONTENT_START (contentOptions| CONTENT_WS)+ CONTENT_CLOSE
    | IN_TAG_URL
    ;

contentOptions
    : CONTENT_TEXT
    | handleInteger
    | CONTENT_EMAIL
    ;

handleInteger
    : INTEGER
    | CONTENT_INTEGER
    ;