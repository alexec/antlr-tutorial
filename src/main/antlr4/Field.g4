grammar Field;

field:
    name=Name NL
    (treasure=Name WS 'scores' WS score=Int WS 'points' NL)+
    (treasure=Name WS 'is' WS 'buried' WS 'at' WS at=location NL)+
    EOF;

location: x=Int ',' y=Int;

Name: '"' ('A'..'Z' | 'a'..'z' | ' ')+ '"' ;
Int: ('0'..'9')+;

WS: (' ' | '\t')+;
NL:  '\r'? '\n';
