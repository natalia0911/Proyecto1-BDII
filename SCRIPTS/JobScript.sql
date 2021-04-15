
BEGIN
    DBMS_SCHEDULER.CREATE_JOB (
            job_name => 'CLOSE_AUCTIONS_JOB',
            job_type => 'STORED_PROCEDURE',
            job_action => 'SP_JOBENDAUCTION',
            number_of_arguments => 0,
            start_date => TO_TIMESTAMP_TZ('2021-04-15 03:22:06.000000000 AMERICA/REGINA','YYYY-MM-DD HH24:MI:SS.FF TZR'),
            repeat_interval => 'FREQ=MINUTELY;INTERVAL=5;BYDAY=MON,TUE,WED,THU,FRI,SAT,SUN',
            end_date => NULL,
            enabled => FALSE,
            auto_drop => FALSE,
            comments => 'Close overdure auctions');


    DBMS_SCHEDULER.SET_ATTRIBUTE( 
             name => 'CLOSE_AUCTIONS_JOB', 
             attribute => 'store_output', value => TRUE);
    DBMS_SCHEDULER.SET_ATTRIBUTE( 
             name => 'CLOSE_AUCTIONS_JOB', 
             attribute => 'logging_level', value => DBMS_SCHEDULER.LOGGING_OFF);

    DBMS_SCHEDULER.enable(
             name => 'CLOSE_AUCTIONS_JOB');
END;


/*
'"NATALIA"."CLOSE_AUCTIONS_JOB"',
'NATALIA.SP_JOBENDAUCTION',
*/