/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

grammar Meta;

options {
    language = Java;
}
 
@header {
    package com.stratio.meta.core.grammar.generated;    
    import com.stratio.meta.core.statements.*;
    import com.stratio.meta.core.structures.*;
    import com.stratio.meta.core.utils.*;
    import java.util.LinkedHashMap;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.Set;
    import java.util.HashSet;
}

@members {
    private ErrorsHelper foundErrors = new ErrorsHelper();

    public ErrorsHelper getFoundErrors(){
        return foundErrors;
    }

    @Override
    public void displayRecognitionError(String[] tokenNames, RecognitionException e){        
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        /*System.err.println("Antlr exception: ");
        System.err.print("\tError recognized: ");
        System.err.print(hdr+": ");
        System.err.println(msg);*/
        AntlrError antlrError = new AntlrError(hdr, msg);
        foundErrors.addError(antlrError);
    }
}

@lexer::header {
    package com.stratio.meta.core.grammar.generated;
}

@lexer::members {
    
}

// Case-insensitive alpha characters
fragment A: ('a'|'A');
fragment B: ('b'|'B');
fragment C: ('c'|'C');
fragment D: ('d'|'D');
fragment E: ('e'|'E');
fragment F: ('f'|'F');
fragment G: ('g'|'G');
fragment H: ('h'|'H');
fragment I: ('i'|'I');
fragment J: ('j'|'J');
fragment K: ('k'|'K');
fragment L: ('l'|'L');
fragment M: ('m'|'M');
fragment N: ('n'|'N');
fragment O: ('o'|'O');
fragment P: ('p'|'P');
fragment Q: ('q'|'Q');
fragment R: ('r'|'R');
fragment S: ('s'|'S');
fragment T: ('t'|'T');
fragment U: ('u'|'U');
fragment V: ('v'|'V');
fragment W: ('w'|'W');
fragment X: ('x'|'X');
fragment Y: ('y'|'Y');
fragment Z: ('z'|'Z');
fragment EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;
fragment POINT: '.';

// Case-insensitive keywords
T_TRUNCATE: T R U N C A T E;
T_CREATE: C R E A T E;
T_ALTER: A L T E R;
T_KEYSPACE: K E Y S P A C E;
T_KEYSPACES: K E Y S P A C E S;
T_NOT: N O T;
T_WITH: W I T H;
T_DROP: D R O P;
T_TABLE: T A B L E;
T_TABLES: T A B L E S;
T_IF: I F;
T_EXISTS: E X I S T S;
T_AND: A N D;
T_USE: U S E;
T_SET: S E T;
T_OPTIONS: O P T I O N S;
T_ANALYTICS: A N A L Y T I C S;
T_TRUE: T R U E;
T_FALSE: F A L S E;
T_CONSISTENCY: C O N S I S T E N C Y;
T_ALL: A L L;
T_ANY: A N Y;
T_QUORUM: Q U O R U M;
T_ONE: O N E;
T_TWO: T W O;
T_THREE: T H R E E;
T_EACH_QUORUM: E A C H '_' Q U O R U M;
T_LOCAL_ONE: L O C A L '_' O N E;
T_LOCAL_QUORUM: L O C A L '_' Q U O R U M;
T_EXPLAIN: E X P L A I N;
T_PLAN: P L A N;
T_FOR: F O R;
T_INDEX: I N D E X;
T_LIST: L I S T;
T_REMOVE: R E M O V E;
T_UDF: U D F;
T_PROCESS: P R O C E S S;
T_TRIGGER: T R I G G E R;
T_STOP: S T O P;
T_ON: O N;
T_USING: U S I N G;
T_TYPE: T Y P E;
T_ADD: A D D;
T_PRIMARY: P R I M A R Y;
T_KEY: K E Y;
T_INSERT: I N S E R T;
T_INTO: I N T O;
T_COMPACT: C O M P A C T;
T_STORAGE: S T O R A G E;
T_CLUSTERING: C L U S T E R I N G;
T_ORDER: O R D E R;
T_SELECT: S E L E C T;
T_VALUES: V A L U E S;
T_UPDATE: U P D A T E;
T_WHERE: W H E R E;
T_IN: I N;
T_FROM: F R O M;
T_DELETE: D E L E T E;
T_WINDOW: W I N D O W;
T_LAST: L A S T;
T_ROWS: R O W S;
T_INNER: I N N E R;
T_JOIN: J O I N;
T_BY: B Y;
T_LIMIT: L I M I T;
T_DISABLE: D I S A B L E;
T_DISTINCT: D I S T I N C T;
T_COUNT: C O U N T;
T_AS: A S;
T_BETWEEN: B E T W E E N;
T_ASC: A S C;
T_DESC: D E S C;
T_LIKE: L I K E;
T_EPHEMERAL: E P H E M E R A L;
T_AT: '@';

T_SEMICOLON: ';';
T_EQUAL: '=';
T_START_SBRACKET: '{';
T_END_SBRACKET: '}';
T_COLON: ':';
T_COMMA: ',';
T_START_PARENTHESIS: '(';
T_END_PARENTHESIS: ')';
T_QUOTE: '"';
T_SINGLE_QUOTE: '\'';
T_DEFAULT: D E F A U L T;
T_LUCENE: L U C E N E;
T_CUSTOM: C U S T O M;
T_START_BRACKET: '[';
T_END_BRACKET: ']';
T_PLUS: '+';
T_SUBTRACT: '-';
T_INTERROGATION: '?';
T_ASTERISK: '*';
T_GROUP: G R O U P;
T_AGGREGATION: A G G R E G A T I O N;
T_SUM: S U M;
T_MAX: M A X;
T_MIN: M I N;
T_AVG: A V G;
T_GT: '>';
T_LT: '<';
T_GTE: '>' '='; 
T_LTE: '<' '=';
T_NOT_EQUAL: '<' '>'; 
T_TOKEN: T O K E N;
T_SECONDS: S E C O N D S;
T_MINUTES: M I N U T E S;
T_HOURS: H O U R S;
T_DAYS: D A Y S;
T_MATCH: M A T C H;
T_DESCRIBE: D E S C R I B E;

fragment LETTER: ('A'..'Z' | 'a'..'z');
fragment DIGIT: '0'..'9';

QUOTED_LITERAL
    @init{ StringBuilder sb = new StringBuilder(); }
    @after{ setText(sb.toString()); }: 
        '\'' (c=~('\'') { sb.appendCodePoint(c);} | '\'' '\'' { sb.appendCodePoint('\''); })* '\''
    ;

T_CONSTANT: (DIGIT)+;

T_IDENT: LETTER (LETTER | DIGIT | '_')*;

T_KS_AND_TN: LETTER (LETTER | DIGIT | '_')* (POINT LETTER (LETTER | DIGIT | '_')*)?; 

T_TERM: (LETTER | DIGIT | '_' | POINT)+;

T_FLOAT:   ('0'..'9')+ POINT ('0'..'9')* EXPONENT?
     |   POINT ('0'..'9')+ EXPONENT?
     |   ('0'..'9')+ EXPONENT
     ;

T_PATH: (LETTER | DIGIT | '_' | POINT | '-' | '/')+;

//STATEMENTS

describeStatement returns [DescribeStatement descs]:
    T_DESCRIBE (T_KEYSPACE keyspace=T_IDENT { $descs = new DescribeStatement(DescribeType.KEYSPACE); $descs.setKeyspace($keyspace.text);}
    	| T_KEYSPACE {$descs = new DescribeStatement(DescribeType.KEYSPACE);}
    	| T_KEYSPACES {$descs = new DescribeStatement(DescribeType.KEYSPACES);}
        | T_TABLE tablename=getTableID { $descs = new DescribeStatement(DescribeType.TABLE); $descs.setTableName(tablename);}
        | T_TABLES {$descs = new DescribeStatement(DescribeType.TABLES);}
    )
;

//DELETE (col1, col2) FROM table1 WHERE field1=value1 AND field2=value2;
deleteStatement returns [DeleteStatement ds]
	@init{
		$ds = new DeleteStatement();
	}:
	T_DELETE 
	(
        T_START_PARENTHESIS
        firstField=(T_IDENT | T_LUCENE) {$ds.addColumn($firstField.text);}
		(T_COMMA field=(T_IDENT | T_LUCENE) {$ds.addColumn($field.text);})*	
        T_END_PARENTHESIS
        )?
	T_FROM
	tableName=getTableID {$ds.setTableName(tableName);}
	T_WHERE
	rel1=getRelation {$ds.addRelation(rel1);} (T_AND relN=getRelation {$ds.addRelation(relN);})*
	;

//ADD \"index_path\";
addStatement returns [AddStatement as]:
	//T_ADD (T_QUOTE | T_SINGLE_QUOTE) name=T_PATH (T_QUOTE | T_SINGLE_QUOTE) {$as = new AddStatement($name.text);}
	T_ADD T_QUOTE name=T_PATH T_QUOTE {$as = new AddStatement($name.text);}
	;

//LIST ( PROCESS | UDF | TRIGGER) ;
listStatement returns [ListStatement ls]:
	T_LIST (type=getListTypes)
	{
		if($type.text != null){
			$ls = new ListStatement($type.text);
		}else{
			throw new RecognitionException();
		}
	}
	;

//REMOVE UDF \"jar.name\";"
removeUDFStatement returns [RemoveUDFStatement rus]:
	//T_REMOVE 'UDF' (T_QUOTE | T_SINGLE_QUOTE) jar=getTerm {$rus = new RemoveUDFStatement(jar);} (T_QUOTE | T_SINGLE_QUOTE)
	T_REMOVE T_UDF (T_QUOTE | T_SINGLE_QUOTE) jar=getTerm {$rus = new RemoveUDFStatement(jar.toString());} (T_QUOTE | T_SINGLE_QUOTE)
	;

//DROP INDEX IF EXISTS index_name;
dropIndexStatement returns [DropIndexStatement dis]
	@init{
		$dis = new DropIndexStatement();
	}:
	T_DROP T_INDEX
	(T_IF T_EXISTS {$dis.setDropIfExists();})?
	name=(T_KS_AND_TN | T_IDENT | T_LUCENE) {$dis.setName($name.text);}
	;


//CREATE HASH INDEX ON table1 (field1, field2);
//CREATE HASH INDEX index1 ON table1 (field1, field2) USING com.company.Index.class;
//CREATE HASH INDEX index1 ON table1 (field1, field2) WITH OPTIONS opt1=val1 AND opt2=val2;
createIndexStatement returns [CreateIndexStatement cis]
	@init{
		$cis = new CreateIndexStatement();
	}:
	T_CREATE indexType=getIndexType {$cis.setIndexType(indexType);} T_INDEX
	(T_IF T_NOT T_EXISTS {$cis.setCreateIfNotExists();})?
	(name=T_IDENT {$cis.setName($name.text);})? 
	T_ON tableName=getTableID {$cis.setTableName(tableName);}
	T_START_PARENTHESIS
            firstField=(T_IDENT | T_LUCENE) {$cis.addColumn($firstField.text);}
	(T_COMMA
		field=(T_IDENT | T_LUCENE) {$cis.addColumn($field.text);}
	)*
	T_END_PARENTHESIS
	(T_USING usingClass=getTerm {$cis.setUsingClass(usingClass.toString());})?
	(T_WITH T_OPTIONS T_EQUAL T_START_SBRACKET key=getValueProperty T_COLON value=getValueProperty {$cis.addOption(key, value);}
		(T_COMMA keyN=getValueProperty T_COLON valueN=getValueProperty {$cis.addOption(keyN, valueN);} )* T_END_SBRACKET
	)?
	;
    //identProp1=T_IDENT T_EQUAL valueProp1=getValueProperty {properties.put($identProp1.text, valueProp1);}
/*
(T_WITH T_OPTIONS T_EQUAL T_START_SBRACKET key=T_IDENT T_COLON value=getValueProperty {$cis.addOption($key.text, value);}
		(T_AND key=T_IDENT T_COLON value=getValueProperty {$cis.addOption($key.text, value);} )* T_END_SBRACKET
*/

updateTableStatement returns [UpdateTableStatement pdtbst]
    @init{
        boolean optsInc = false;
        boolean condsInc = false;
        ArrayList<Option> options = new ArrayList<>();
        ArrayList<Assignment> assignments = new ArrayList<>();
        ArrayList<Relation> whereclauses = new ArrayList<>();
        Map<String, Term<?>> conditions = new HashMap<>();
    }:
    T_UPDATE tablename=getTableID
    (T_USING opt1=getOption {optsInc = true; options.add(opt1);} (T_AND optN=getOption {options.add(optN);})*)?
    T_SET assig1=getAssignment {assignments.add(assig1);} (T_COMMA assigN=getAssignment {assignments.add(assigN);})*
    T_WHERE rel1=getRelation {whereclauses.add(rel1);} (T_AND relN=getRelation {whereclauses.add(relN);})*
    (T_IF id1=T_IDENT T_EQUAL term1=getTerm {condsInc = true; conditions.put($id1.text, term1);}
                    (T_AND idN=T_IDENT T_EQUAL termN=getTerm {conditions.put($idN.text, termN);})*)?
    { 
        if(optsInc)
            if(condsInc)
                $pdtbst = new UpdateTableStatement(tablename, options, assignments, whereclauses, conditions);
            else
                $pdtbst = new UpdateTableStatement(tablename, options, assignments, whereclauses);
        else
            if(condsInc)
                $pdtbst = new UpdateTableStatement(tablename, assignments, whereclauses, conditions);
            else
                $pdtbst = new UpdateTableStatement(tablename, assignments, whereclauses);
    }
    ;

stopProcessStatement returns [StopProcessStatement stprst]:
    T_STOP T_PROCESS ident=T_IDENT { $stprst = new StopProcessStatement($ident.text); }
    ;

dropTriggerStatement returns [DropTriggerStatement drtrst]:
    T_DROP 
    T_TRIGGER ident=T_IDENT 
    T_ON 
    ident2=T_IDENT  
    {$drtrst = new DropTriggerStatement($ident.text,$ident2.text);}
    ;

createTriggerStatement returns [CreateTriggerStatement crtrst]:
    T_CREATE 
    T_TRIGGER trigger_name=T_IDENT 
    T_ON 
    table_name=T_IDENT
    T_USING class_name=T_IDENT    
    {$crtrst = new CreateTriggerStatement($trigger_name.text,$table_name.text,$class_name.text);}
    ;


createTableStatement returns [CreateTableStatement crtast]
@init{
    LinkedHashMap<String, String> columns = new LinkedHashMap<>();
    ArrayList<String>   primaryKey = new ArrayList<String>();
    ArrayList<String> clusterKey = new ArrayList<String>();
    int primaryKeyType = 0;
    int columnNumberPK= 0;
    int columnNumberPK_inter= 0;
    boolean ifNotExists = false;
    boolean withProperties = false;
    }:    
    T_CREATE
    T_TABLE
    (T_IF T_NOT T_EXISTS {ifNotExists = true;})?
    tablename=getTableID
    T_START_PARENTHESIS (            
                ident_column1=(T_IDENT | T_LUCENE | T_KEY) type1=getDataType (T_PRIMARY T_KEY)? {columns.put($ident_column1.text,type1); primaryKeyType=1;}
                (   
                    ( T_COMMA ident_columN=(T_IDENT | T_LUCENE | T_KEY) typeN=getDataType (T_PRIMARY T_KEY {primaryKeyType=1;columnNumberPK=columnNumberPK_inter +1;})? {columns.put($ident_columN.text,typeN);columnNumberPK_inter+=1;})
                    |(  
                        T_COMMA T_PRIMARY T_KEY T_START_PARENTHESIS
                        (
                            (   primaryK=(T_IDENT | T_LUCENE | T_KEY) {primaryKey.add($primaryK.text);primaryKeyType=2;}
                           
                                (T_COMMA partitionKN=(T_IDENT | T_LUCENE | T_KEY) {primaryKey.add($partitionKN.text);})*
                            )
                            |(
                                T_START_PARENTHESIS partitionK=(T_IDENT | T_LUCENE | T_KEY) {primaryKey.add($partitionK.text);primaryKeyType=3;}
                                    (T_COMMA partitionKN=(T_IDENT | T_LUCENE | T_KEY) {primaryKey.add($partitionKN.text);})*
                                T_END_PARENTHESIS 
                                (T_COMMA clusterKN=(T_IDENT | T_LUCENE | T_KEY) {clusterKey.add($clusterKN.text);})*

                            )
                        )
                       T_END_PARENTHESIS 
                   )
                )* 
         )             
    T_END_PARENTHESIS (T_WITH {withProperties=true;} properties=getMetaProperties)?
    {
        $crtast = new CreateTableStatement(tablename, columns, primaryKey, clusterKey, primaryKeyType, columnNumberPK);
        $crtast.setProperties(properties);
        $crtast.setIfNotExists(ifNotExists);
        $crtast.setWithProperties(withProperties);
    }
;        

        
alterTableStatement returns [AlterTableStatement altast]
@init{
        int option= 0;
    }:
    T_ALTER
    T_TABLE
    tablename=getTableID
    (T_ALTER column=(T_IDENT | T_LUCENE) T_TYPE type=T_IDENT {option=1;}
        |T_ADD column=(T_IDENT | T_LUCENE) type=T_IDENT {option=2;}
        |T_DROP column=(T_IDENT | T_LUCENE) {option=3;}
        |(T_WITH {option=4;} props=getMetaProperties)?
    )
    {$altast = new AlterTableStatement(tablename, $column.text, $type.text, props, option);  }
;

selectStatement returns [SelectStatement slctst]
    @init{
        boolean windowInc = false;
        boolean joinInc = false;
        boolean whereInc = false;
        boolean orderInc = false;
        boolean groupInc = false;
        boolean limitInc = false;
        boolean disable = false;
    }:
    T_SELECT selClause=getSelectClause T_FROM tablename=getTableID 
    (T_WITH T_WINDOW {windowInc = true;} window=getWindow)?    
    (T_INNER T_JOIN { joinInc = true;} identJoin=getTableID T_ON fields=getFields)?
    (T_WHERE {whereInc = true;} whereClauses=getWhereClauses)?
    (T_ORDER T_BY {orderInc = true;} ordering=getOrdering)?
    (T_GROUP T_BY {groupInc = true;} groupby=getList)?
    (T_LIMIT {limitInc = true;} constant=getConstant)?
    (T_DISABLE T_ANALYTICS {disable = true;})?
    {
        $slctst = new SelectStatement(selClause, tablename);        
        if(windowInc)
            $slctst.setWindow(window);
        if(joinInc)
            $slctst.setJoin(new InnerJoin(identJoin, fields)); 
        if(whereInc)
             $slctst.setWhere(whereClauses); 
        if(orderInc)
             $slctst.setOrder(ordering);
        if(groupInc)
            $slctst.setGroup(new GroupBy(groupby)); 
        if(limitInc)
            $slctst.setLimit(Integer.parseInt(constant));
        if(disable)
            $slctst.setDisableAnalytics(true);
    };

insertIntoStatement returns [InsertIntoStatement nsntst]
    @init{
        ArrayList<String> ids = new ArrayList<>();
        boolean ifNotExists = false;
        int typeValues = InsertIntoStatement.TYPE_VALUES_CLAUSE;
        ArrayList<ValueCell<?>> cellValues = new ArrayList<>();
        boolean optsInc = false;
        ArrayList<Option> options = new ArrayList<>();
    }:
    T_INSERT 
    T_INTO 
    tableName=getTableID
    T_START_PARENTHESIS 
    ident1=(T_IDENT | T_LUCENE) {ids.add($ident1.text);} 
    (T_COMMA identN=(T_IDENT | T_LUCENE) {ids.add($identN.text);})* 
    T_END_PARENTHESIS
    ( 
        selectStmnt=selectStatement {typeValues = InsertIntoStatement.TYPE_SELECT_CLAUSE;}
        | 
        T_VALUES
        T_START_PARENTHESIS 
            term1=getTermOrLiteral {cellValues.add(term1);}
            (T_COMMA termN=getTermOrLiteral {cellValues.add(termN);})*
        T_END_PARENTHESIS
    )
    (T_IF T_NOT T_EXISTS {ifNotExists=true;} )?
    (
        T_USING {optsInc=true;} 
        opt1=getOption {
            options.add(opt1);
        }
        (T_AND optN=getOption {options.add(optN);})*
    )?
    {
        if(typeValues==InsertIntoStatement.TYPE_SELECT_CLAUSE)
            if(optsInc)
                $nsntst = new InsertIntoStatement(tableName, ids, selectStmnt, ifNotExists, options);
            else
                $nsntst = new InsertIntoStatement(tableName, ids, selectStmnt, ifNotExists);
        else
            if(optsInc)
                $nsntst = new InsertIntoStatement(tableName, ids, cellValues, ifNotExists, options);
            else
                $nsntst = new InsertIntoStatement(tableName, ids, cellValues, ifNotExists);
                
    }
    ;

explainPlanStatement returns [ExplainPlanStatement xpplst]:
    T_EXPLAIN T_PLAN T_FOR parsedStmnt=metaStatement
    {$xpplst = new ExplainPlanStatement(parsedStmnt);}
    ;

setOptionsStatement returns [SetOptionsStatement stptst]
    @init{
        ArrayList<Boolean> checks = new ArrayList<>();
        checks.add(false);
        checks.add(false);
        boolean analytics = false;
        Consistency cnstc=Consistency.ALL;
    }:
    T_SET T_OPTIONS (
        T_ANALYTICS T_EQUAL (T_TRUE{analytics=true;}|T_FALSE{analytics=false;}) {checks.set(0, true);}
        (T_AND T_CONSISTENCY T_EQUAL
            (T_ALL {cnstc=Consistency.ALL;} 
            | T_ANY {cnstc=Consistency.ANY;}
            | T_QUORUM {cnstc=Consistency.QUORUM;}
            | T_ONE {cnstc=Consistency.ONE;}
            | T_TWO {cnstc=Consistency.TWO;}
            | T_THREE {cnstc=Consistency.THREE;}
            | T_EACH_QUORUM {cnstc=Consistency.EACH_QUORUM;}
            | T_LOCAL_ONE {cnstc=Consistency.LOCAL_ONE;}
            | T_LOCAL_QUORUM {cnstc=Consistency.LOCAL_QUORUM;})
            {checks.set(1, true);}
        )?
        { $stptst = new SetOptionsStatement(analytics, cnstc, checks);}
        | T_CONSISTENCY T_EQUAL 
            (T_ALL {cnstc=Consistency.ALL;} 
            | T_ANY {cnstc=Consistency.ANY;}
            | T_QUORUM {cnstc=Consistency.QUORUM;}
            | T_ONE {cnstc=Consistency.ONE;}
            | T_TWO {cnstc=Consistency.TWO;}
            | T_THREE {cnstc=Consistency.THREE;}
            | T_EACH_QUORUM {cnstc=Consistency.EACH_QUORUM;}
            | T_LOCAL_ONE {cnstc=Consistency.LOCAL_ONE;}
            | T_LOCAL_QUORUM {cnstc=Consistency.LOCAL_QUORUM;})
            {checks.set(1, true);}
        (T_AND T_ANALYTICS T_EQUAL (T_TRUE{analytics=true;}|T_FALSE{analytics=false;}) 
            {checks.set(0, true);})?
        { $stptst = new SetOptionsStatement(analytics, cnstc, checks);}
    );

useStatement returns [UseStatement usst]:
    T_USE
    iden=T_IDENT {$usst = new UseStatement($iden.text);};

dropKeyspaceStatement returns [DropKeyspaceStatement drksst]
    @init{
        boolean ifExists = false;
    }:
    T_DROP
    T_KEYSPACE
    (T_IF T_EXISTS {ifExists = true;})?
    iden=T_IDENT
    { $drksst = new DropKeyspaceStatement($iden.text, ifExists);};

alterKeyspaceStatement returns [AlterKeyspaceStatement alksst]
    @init{
        HashMap<String, ValueProperty> properties = new HashMap<>();
    }:
    T_ALTER
    T_KEYSPACE
    ident=T_IDENT
    T_WITH
    identProp1=T_IDENT T_EQUAL valueProp1=getValueProperty {properties.put($identProp1.text, valueProp1);}
    (T_AND identPropN=T_IDENT T_EQUAL valuePropN=getValueProperty {properties.put($identPropN.text, valuePropN);} )*
    { $alksst = new AlterKeyspaceStatement($ident.text, properties); };

createKeyspaceStatement returns [CreateKeyspaceStatement crksst]
    @init{
        boolean ifNotExists = false;
        HashMap<String, ValueProperty> properties = new HashMap<>();
    }:
    T_CREATE T_KEYSPACE
    (T_IF T_NOT T_EXISTS {ifNotExists = true;})?
    identKS=T_IDENT
    T_WITH    
    identProp1=T_IDENT T_EQUAL valueProp1=getValueProperty {properties.put($identProp1.text, valueProp1);}
    (T_AND identPropN=T_IDENT T_EQUAL valuePropN=getValueProperty {properties.put($identPropN.text, valuePropN);})*
    { $crksst = new CreateKeyspaceStatement($identKS.text, ifNotExists, properties); };

dropTableStatement returns [DropTableStatement drtbst]
    @init{
        boolean ifExists = false;
    }:
    T_DROP
    T_TABLE
    (T_IF T_EXISTS { ifExists = true; })?
    identID=getTableID {
        $drtbst = new DropTableStatement(identID, ifExists);
    };

truncateStatement returns [TruncateStatement trst]: 
	T_TRUNCATE 
        ident=getTableID {
            $trst = new TruncateStatement(ident);
	};

metaStatement returns [MetaStatement st]:
    st_crta= createTableStatement { $st = st_crta;}
    | st_alta= alterTableStatement { $st = st_alta;}
    | st_crtr= createTriggerStatement { $st = st_crtr; }
    | st_drtr= dropTriggerStatement { $st = st_drtr; }
    | st_stpr = stopProcessStatement { $st = st_stpr; }
    | st_pdtb = updateTableStatement { $st = st_pdtb; }
    | st_slct = selectStatement { $st = st_slct;}
    | st_nsnt = insertIntoStatement { $st = st_nsnt;}
    | st_xppl = explainPlanStatement { $st = st_xppl;}
    | st_stpt = setOptionsStatement { $st = st_stpt; }
    | st_usks = useStatement { $st = st_usks; }
    | st_drks = dropKeyspaceStatement { $st = st_drks ;}
    | st_crks = createKeyspaceStatement { $st = st_crks; }
    | st_alks = alterKeyspaceStatement { $st = st_alks; }
    | st_tbdr = dropTableStatement { $st = st_tbdr; }
    | st_trst = truncateStatement { $st = st_trst; }
    | cis = createIndexStatement { $st = cis; } 
    | dis = dropIndexStatement { $st = dis; } 
    | ls = listStatement { $st = ls; } 
    | add = addStatement { $st = add; } 
    | rs = removeUDFStatement { $st = rs; } 
    | ds = deleteStatement { $st = ds; } 
    | descs = describeStatement { $st = descs;}
    ;

query returns [MetaStatement st]: 
	mtst=metaStatement (T_SEMICOLON)+ EOF {
		$st = mtst;
	};


//FUNCTIONS
getIndexType returns [String indexType]:
    ( idxType=T_DEFAULT
    | idxType=T_LUCENE
    | idxType=T_CUSTOM)
    {$indexType=$idxType.text;}
;

getMetaProperties returns [ArrayList<Property> props]
    @init{
        $props = new ArrayList<>();
    }:
    firstProp=getMetaProperty {$props.add(firstProp);}
    (T_AND newProp=getMetaProperty {$props.add(newProp);})*
;

getMetaProperty returns [Property mp]
    @init{
        BooleanProperty boolProp = new BooleanProperty(true);
    }:
    (identProp=T_IDENT T_EQUAL valueProp=getValueProperty {$mp = new PropertyNameValue($identProp.text, valueProp);} 
    | T_COMPACT T_STORAGE {$mp = new PropertyCompactStorage();}
    | T_CLUSTERING T_ORDER T_BY T_START_PARENTHESIS ordering=getOrdering {$mp = new PropertyClusteringOrder(ordering);} T_END_PARENTHESIS)
    | T_EPHEMERAL ( | T_EQUAL (T_FALSE {new BooleanProperty(false);} | T_TRUE )) {$mp = new PropertyNameValue("ephemeral", boolProp);}
;

getDataType returns [String dataType]:
    (
        ident1=T_IDENT (T_LT ident2=T_IDENT (T_COMMA ident3=T_IDENT)? T_GT)?
    )
    {$dataType = $ident1.text.concat(ident2==null?"":"<"+$ident2.text).concat(ident3==null?"":","+$ident3.text).concat(ident2==null?"":">");}
;

getOrdering returns [ArrayList<Ordering> order]
    @init{
        order = new ArrayList<>();
        Ordering ordering;
    }:
    ident1=(T_KS_AND_TN | T_IDENT) {ordering = new Ordering($ident1.text);} (T_ASC {ordering.setOrderDir(OrderDirection.ASC);} | T_DESC {ordering.setOrderDir(OrderDirection.DESC);})? {order.add(ordering);}
    (T_COMMA identN=(T_KS_AND_TN | T_IDENT) {ordering = new Ordering($identN.text);} (T_ASC {ordering.setOrderDir(OrderDirection.ASC);} | T_DESC {ordering.setOrderDir(OrderDirection.DESC);})? {order.add(ordering);})*
;

getWhereClauses returns [ArrayList<Relation> clauses]
    @init{
        clauses = new ArrayList<>();
    }:
    rel1=getRelation {clauses.add(rel1);} (T_AND relN=getRelation {clauses.add(relN);})*
;

getFields returns [Map<String, String> fields]
    @init{
        fields = new HashMap<>();
    }:
    ident1L=getTableID T_EQUAL ident1R=getTableID { fields.put(ident1L, ident1R);}
    (T_AND identNL=getTableID T_EQUAL identNR=getTableID { fields.put(identNL, identNR);})* 
;

getWindow returns [WindowSelect ws]:
    (T_LAST {$ws = new WindowLast();} 
    | cnstnt=getConstant (T_ROWS {$ws = new WindowRows(Integer.parseInt(cnstnt));}
                       | unit=getTimeUnit {$ws = new WindowTime(Integer.parseInt(cnstnt), unit);}
                       )
    );

getTimeUnit returns [TimeUnit unit]:
    ( 'S' {$unit=TimeUnit.SECONDS;}
    | 'M' {$unit=TimeUnit.MINUTES;}
    | 'H' {$unit=TimeUnit.HOURS;}
    | 'D' {$unit=TimeUnit.DAYS;}
    | 's' {$unit=TimeUnit.SECONDS;}
    | 'm' {$unit=TimeUnit.MINUTES;}
    | 'h' {$unit=TimeUnit.HOURS;}
    | 'd' {$unit=TimeUnit.DAYS;}
    | T_SECONDS {$unit=TimeUnit.SECONDS;}
    | T_MINUTES {$unit=TimeUnit.MINUTES;}
    | T_HOURS {$unit=TimeUnit.HOURS;}
    | T_DAYS {$unit=TimeUnit.DAYS;}
    )
;

getSelectClause returns [SelectionClause sc]:
    scc=getSelectionCount {$sc = scc;}
    | scl=getSelectionList {$sc = scl;}
;

getSelectionCount returns [SelectionCount scc]
    @init{
        boolean identInc = false;
        char symbol = '*';
    }:
    T_COUNT T_START_PARENTHESIS symbolStr=getCountSymbol { symbol=symbolStr.charAt(0); } T_END_PARENTHESIS
    (T_AS {identInc = true;} ident=T_IDENT )? 
    {
        if(identInc)
            $scc = new SelectionCount(symbol, identInc, $ident.text);
        else
            $scc = new SelectionCount(symbol);
    }
;

getCountSymbol returns [String str]:
    '*' {$str = new String("*");}
    | '1' {$str = new String("1");}
    ;

getSelectionList returns [SelectionList scl]
    @init{
        boolean distinct = false;
    }:
    (T_DISTINCT {distinct = true;})? selections=getSelection
    { $scl = new SelectionList(distinct, selections);}
;

getSelection returns [Selection slct]
    @init{
        SelectionSelector slsl;
        ArrayList<SelectionSelector> selections = new ArrayList<>();
    }:
    (
        T_ASTERISK { $slct = new SelectionAsterisk();}       
        | selector1=getSelector { slsl = new SelectionSelector(selector1);} (T_AS ident1=T_IDENT {slsl.setAlias($ident1.text);})? {selections.add(slsl);}
            (T_COMMA selectorN=getSelector {slsl = new SelectionSelector(selectorN);} (T_AS identN=T_IDENT {slsl.setAlias($identN.text);})? {selections.add(slsl);})*
            { $slct = new SelectionSelectors(selections);}
    )
;

getSelector returns [SelectorMeta slmt]
    @init{
        ArrayList<SelectorMeta> params = new ArrayList<>();
        GroupByFunction gbFunc = null;
    }:
    ( (T_SUM {gbFunc = GroupByFunction.SUM;}
       | T_MAX {gbFunc = GroupByFunction.MAX;}
       | T_MIN {gbFunc = GroupByFunction.MIN;}
       | T_AVG {gbFunc = GroupByFunction.AVG;}
       | T_COUNT {gbFunc = GroupByFunction.COUNT;}
      ) 
            T_START_PARENTHESIS 
                (select1=getSelector {params.add(select1);}
                | T_ASTERISK {params.add(new SelectorIdentifier("*"));}
                )?
            T_END_PARENTHESIS {$slmt = new SelectorGroupBy(gbFunc, params.get(0));}
        | (identID=getTableID | luceneID=T_LUCENE) (
            {if (identID != null) $slmt = new SelectorIdentifier(identID); else $slmt = new SelectorIdentifier($luceneID.text);}
            | T_START_PARENTHESIS (select1=getSelector {params.add(select1);} (T_COMMA selectN=getSelector {params.add(selectN);})*)? 
                T_END_PARENTHESIS {$slmt = new SelectorFunction(identID, params);}
        )
    )
;

getListTypes returns [String listType]:
	//ident=('PROCESS' | 'UDF' | 'TRIGGER' | 'process' | 'udf' | 'trigger') {$listType = new String($ident.text);}
	//ident=('PROCESS' | 'UDF' | 'TRIGGER') {$listType = new String($ident.text);}
	//ident=(T_PROCESS | 'UDF' | 'TRIGGER') {$listType = new String($ident.text);}
	ident=(T_PROCESS | T_UDF | T_TRIGGER) {$listType = new String($ident.text);}
	;

getAssignment returns [Assignment assign]:
    ident=T_IDENT (
        T_EQUAL value=getValueAssign {$assign = new Assignment(new IdentifierAssignment($ident.text), value);} 
        | T_START_BRACKET termL=getTerm T_END_BRACKET T_EQUAL termR=getTerm {
            $assign = new Assignment (new IdentifierAssignment($ident.text, termL), new ValueAssignment(termR));
        }
    )
; 

getValueAssign returns [ValueAssignment valueAssign]:
    term1=getTerm { $valueAssign = new ValueAssignment(term1);}
    | ident=T_IDENT (T_PLUS (T_START_SBRACKET mapLiteral=getMapLiteral T_END_SBRACKET { $valueAssign = new ValueAssignment(new IdentMap($ident.text, new MapLiteralProperty(mapLiteral)));}
                                | value1=getIntSetOrList {
                                                            if(value1 instanceof IntTerm)
                                                                $valueAssign = new ValueAssignment(new IntTerm($ident.text, '+', ((IntTerm) value1).getTerm()));
                                                            else if(value1 instanceof ListLiteral)
                                                                $valueAssign = new ValueAssignment(new ListLiteral($ident.text, '+', ((ListLiteral) value1).getLiterals()));
                                                            else
                                                                $valueAssign = new ValueAssignment(new SetLiteral($ident.text, '+', ((SetLiteral) value1).getLiterals()));
                                                         }
                           ) 
                    | T_SUBTRACT value2=getIntSetOrList {
                                                if(value2 instanceof IntTerm)
                                                    $valueAssign = new ValueAssignment(new IntTerm($ident.text, '-', ((IntTerm) value2).getTerm()));
                                                else if(value2 instanceof ListLiteral)
                                                    $valueAssign = new ValueAssignment(new ListLiteral($ident.text, '-', ((ListLiteral) value2).getLiterals()));
                                                else
                                                    $valueAssign = new ValueAssignment(new SetLiteral($ident.text, '-', ((SetLiteral) value2).getLiterals()));
                                                }
                )
;

getIntSetOrList returns [IdentIntOrLiteral iiol]:
    constant=getConstant { $iiol = new IntTerm(Integer.parseInt(constant));}
    | T_START_BRACKET list=getList T_END_BRACKET { $iiol = new ListLiteral(list);}
    | T_START_SBRACKET set=getSet T_END_SBRACKET { $iiol = new SetLiteral(set);}
;

getRelation returns [Relation mrel]:
    T_TOKEN T_START_PARENTHESIS listIds=getIds T_END_PARENTHESIS operator=getComparator (term=getTerm {$mrel = new RelationToken(listIds, operator, term);}
                            | T_TOKEN T_START_PARENTHESIS terms=getTerms T_END_PARENTHESIS {$mrel = new RelationToken(listIds, operator, terms);})
    | (ident=T_IDENT | ident=T_KS_AND_TN) ( compSymbol=getComparator termR=getTerm {$mrel = new RelationCompare($ident.text, compSymbol, termR);}
                    | T_IN T_START_PARENTHESIS terms=getTerms T_END_PARENTHESIS {$mrel = new RelationIn($ident.text, terms);}
                    | T_BETWEEN term1=getTerm T_AND term2=getTerm {$mrel = new RelationBetween($ident.text, term1, term2);}
                    )
;

getComparator returns [String comparator]:
    T_EQUAL {$comparator="=";}
    | T_GT {$comparator=">";}
    | T_LT {$comparator="<";}
    | T_GTE {$comparator=">=";} 
    | T_LTE {$comparator="<=";}
    | T_NOT_EQUAL {$comparator="<>";} 
    | T_LIKE {$comparator="LIKE";}
    | T_MATCH {$comparator="MATCH";}
;

getIds returns [ArrayList<String> listStrs]
    @init{
        listStrs = new ArrayList<>();
    }:
    ident1=T_IDENT {listStrs.add($ident1.text);} (T_COMMA identN=T_IDENT {listStrs.add($identN.text);})*
;

getOptions returns [ArrayList<Option> opts]@init{
        opts = new ArrayList<>();
    }:
    opt1=getOption {opts.add(opt1);} (optN=getOption {opts.add(optN);})*
;

getOption returns [Option opt]:
    T_COMPACT T_STORAGE {$opt=new Option(Option.OPTION_COMPACT);}
    | T_CLUSTERING T_ORDER {$opt=new Option(Option.OPTION_CLUSTERING);}
    | identProp=T_IDENT T_EQUAL valueProp=getValueProperty {$opt=new Option($identProp.text, valueProp);}
;

getList returns [ArrayList list]
    @init{
        list = new ArrayList<String>();
    }:
    term1=getTerm {list.add(term1.toString());}
    (T_COMMA termN=getTerm {list.add(termN.toString());})*
    ;

getTerms returns [ArrayList list]
    @init{
        list = new ArrayList<Term>();
    }:
    term1=getTerm {list.add(term1);}
    (T_COMMA termN=getTerm {list.add(termN);})*
    ;

getSet returns [Set set]
    @init{
        set = new HashSet<String>();
    }:
    term1=getTerm {set.add(term1.toString());}
    (T_COMMA termN=getTerm {set.add(termN.toString());})*
    ;

getTermOrLiteral returns [ValueCell vc]
    @init{
        CollectionLiteral cl = new CollectionLiteral();
    }:
    term=getTerm {$vc=term;}
    |
    T_START_SBRACKET
    (
        term1=getTerm {cl.addLiteral(term1);}
        (T_COMMA termN=getTerm {cl.addLiteral(termN);})*
    )?
    T_END_SBRACKET {$vc=cl;}
;

getTableID returns [String tableID]
    @init{
        $tableID="";
    }: 
    (ident1=T_IDENT {$tableID = new String($ident1.text);}    
    | ident2=T_KS_AND_TN {$tableID = new String($ident2.text);})
    ;

getTerm returns [Term term]:
    term1=getPartialTerm ( {$term = term1;} | 
    T_AT term2=getPartialTerm {$term = new StringTerm(term1.getTermValue()+"@"+term2.getTermValue());} )
;

getPartialTerm returns [Term term]:
    ident=T_IDENT {$term = new StringTerm($ident.text);}
    | constant=getConstant {$term = new LongTerm(constant);}
    | T_FALSE {$term = new BooleanTerm("false");}
    | T_TRUE {$term = new BooleanTerm("true");}
    | floatingNumber=T_FLOAT {$term = new DoubleTerm($floatingNumber.text);}
    | ksAndTn=T_KS_AND_TN {$term = new StringTerm($ksAndTn.text);}
    | noIdent=T_TERM {$term = new StringTerm($noIdent.text);}
    | path=T_PATH {$term = new StringTerm($path.text);}
    | qLiteral=QUOTED_LITERAL {$term = new StringTerm($qLiteral.text, true);}
;

getMapLiteral returns [Map<String, String> mapTerms]
    @init{
        $mapTerms = new HashMap<>();
    }:
    T_START_SBRACKET 
    (leftTerm1=getTerm T_COLON rightTerm1=getTerm {$mapTerms.put(leftTerm1.toString(), rightTerm1.toString());}
    (T_COMMA leftTermN=getTerm T_COLON rightTermN=getTerm {$mapTerms.put(leftTermN.toString(), rightTermN.toString());})*)?
    T_END_SBRACKET
    ;

getValueProperty returns [ValueProperty value]:
    ident=T_IDENT {$value = new IdentifierProperty($ident.text);}
    | constant=getConstant {$value = new ConstantProperty(Integer.parseInt(constant));}
    | mapliteral=getMapLiteral {$value = new MapLiteralProperty(mapliteral);}
    | number=getFloat {$value = new FloatProperty(Float.parseFloat(number));}
    | T_FALSE {$value = new BooleanProperty(false);}
    | T_TRUE {$value = new BooleanProperty(true);}
    | T_COMPACT T_STORAGE {$value = new IdentifierProperty("COMPACT STORAGE");}
    | T_CLUSTERING T_ORDER {$value = new IdentifierProperty("CLUSTERING ORDER");}
    | quotedLiteral=QUOTED_LITERAL {$value = new QuotedLiteral($quotedLiteral.text);}
    ;

getConstant returns [String constStr]:
    constToken=T_CONSTANT {$constStr = new String($constToken.text);}
    | '1' {$constStr = new String("1");}
    ;

getFloat returns [String floating]:
    termToken=T_TERM {$floating=$termToken.text;}
    | floatToken = T_FLOAT {$floating=$floatToken.text;}
    ;

WS: (' ' | '\t' | '\n' | '\r')+ { 
        $channel = HIDDEN; 
    };
