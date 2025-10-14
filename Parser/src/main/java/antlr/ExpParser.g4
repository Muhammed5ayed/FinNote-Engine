parser grammar ExpParser;
options { tokenVocab=ExpLexer;}


prog : NEWLINE?(line NEWLINE)* line?;

line : call_Method | expersion | save_var;

save_var :  LABEL EQUALS (FIND | expersion | call_Method);

call_Method : LABEL BEGINGROUB (expersion COMMEA)*expersion? ENDGROUB;



expersion :   MINUS LABEL
            | MINUS NUMBER
            | MINUS VALUE_VAR
            | MINUS call_Method
            | call_Method
            | BEGINGROUB expersion ENDGROUB
            | left=expersion op=POW right=expersion
            | left=expersion op=(TIMES | DIVIDE) right=expersion
            | left=expersion op= ( PLUS | MINUS ) right=expersion
            | STRING
            | LABEL
            | NUMBER
            | VALUE_VAR
            ;