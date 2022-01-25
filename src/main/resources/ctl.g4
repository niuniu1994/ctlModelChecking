grammar ctl;

//token valeurs

AND : '&&';
OR : '||';
IMPLY : '=>';
NOT: '^';
TRUE: 'true';
FALSE: 'false';
A :'A';
E :'E';
U :'U';
AX : 'AX';
AG : 'AG';
AF : 'AF';
EF : 'EF';
EG : 'EG';
EX : 'EX';
LEFT_BRACKTET : '(';
RIGHT_BRACKTET : ')';

ATOM : [a-z]+;

//fucntions
expression:
     ATOM                        #atomHandler
    | FALSE                      #falseHandler
    | TRUE                       #trueHandler
    | left=expression AND right=expression       #andHandler
    | LEFT_BRACKTET val = expression RIGHT_BRACKTET     #bracketHandler
    | left=expression OR right=expression              #orHandler
    | left=expression IMPLY right=expression             #implyHandler
    | NOT LEFT_BRACKTET val=expression RIGHT_BRACKTET          #notHandler
    | AX  LEFT_BRACKTET val=expression RIGHT_BRACKTET                                    #axHandler
    | AF  LEFT_BRACKTET val=expression RIGHT_BRACKTET                                      #afHandler
    | AG  LEFT_BRACKTET val=expression RIGHT_BRACKTET                                  #agHandler
    | A LEFT_BRACKTET left=expression U right=expression RIGHT_BRACKTET                     #auHandler
    | EX  LEFT_BRACKTET al=expression RIGHT_BRACKTET                                   #exHandler
    | EF  LEFT_BRACKTET val=expression RIGHT_BRACKTET                                       #efHandler
    | EG  LEFT_BRACKTET val=expression RIGHT_BRACKTET                                       #egHandler
    | E LEFT_BRACKTET left=expression U right=expression RIGHT_BRACKTET                     #euHandler;