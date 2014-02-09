grammar Field;

field:
    name=Name NL
    (points NL)+
    (burial NL)+
    EOF;

points: treasure=Name WS 'scores' WS value=Int WS 'points';
burial: treasure=Name WS 'is' WS 'buried' WS 'at' WS at=location ;
location: x=Int ',' y=Int;

Name: '"' ('A'..'Z' | 'a'..'z' | ' ')+ '"' ;
Int: ('0'..'9')+;

WS: (' ' | '\t')+;
NL:  '\r'? '\n';
