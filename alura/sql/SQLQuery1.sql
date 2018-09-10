BACKUP DATABASE sql_avancado TO DISK='/opt/db/adw.bak';
drop database sql_avancado;
RESTORE DATABASE sql_avancado FROM DISK='/opt/db/adw.bak'


RESTORE DATABASE Sealed_Desenvolvimento FROM DISK='/opt/db/PrintCenter.bak'


