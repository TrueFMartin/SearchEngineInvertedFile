lexer grammar IRLexer;


// Tag open and close
TAG_START: '<' [A-Za-z0-9]+? '>';
TAG_END: '</' [A-Za-z0-9]+ '>';
// The opening of a tag with attributes, e.g. <IMG someatributes=here..
TAG_START_OPEN: '<' [A-Za-z0-9]+ ' ' -> mode(IN_TAG);

URL: ( 'http://' | 'https://' )? 'www' ([A-Za-z0-9.\-_]+? ( '.' )+)+ (PLAIN_TEXT|[0-9-_'./\\~,`!@#$%^&*():;<>{}])+?;
EMAIL: [A-Za-z0-9.\-_]+? '@' [A-Za-z0-9.\-_]+ '.' [a-z][a-z][a-z]?;
FLOAT: INTEGER'.'INTEGER~'.' -> skip;
PUNCT: [-_'./\\~,`!@#$%^&*():;<>{}]+? -> skip;
INTEGER: [0-9,]+;
PLAIN_TEXT: [A-Za-z]+;
TEXT_WITH_PUNCTUATION: (PLAIN_TEXT|[0-9-_'./\\~,`!@#$%^&*():;<>{}])+?;
NEW_LINE: ('/r'? '\n');
WS: (' '|'\t'|'\r'? '\n')+ -> skip;
OTHER: .+?;

// The space indicated by XXX: <tagName XXX >
mode IN_TAG;
TAG_START_CLOSE: ('>'|'/>') -> mode(DEFAULT_MODE);
IN_TAG_URL: 'href="' URL '"';
CONTENT_START: ('content'|'alt')'="' TEXT_WITH_PUNCTUATION-> mode(CONTENT_MODE);
ATTRIBUTE_IGNORE: PLAIN_TEXT'="'PLAIN_TEXT'"' -> skip;
FILLER: PLAIN_TEXT -> skip;
TAG_WS: WS -> skip;
AWS: (' '|'\t'|'\r'? '\n')+ -> skip;

// Inside of a tag, any content or alt attribute, e.g. <IMG alt="XXX">
mode CONTENT_MODE;
CONTENT_CLOSE: '"' -> mode(IN_TAG);
CONTENT_FLOAT: FLOAT -> skip;
CONTENT_INTEGER: [0-9]?INTEGER?[0-9];
CONTENT_EMAIL: EMAIL;
CONTENT_TEXT: PLAIN_TEXT;
CONTENT_PUNCTUATION: PUNCT -> skip;
CONTENT_WS: ' ';
