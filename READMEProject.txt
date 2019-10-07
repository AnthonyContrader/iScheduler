Default database configuration is in config.properties
Set like default JRE System Library jre v1.8
Add to Build Path the jar contained in "lib" folder


Per Importare il DB andare sulla workbench di MySQL, sulla barra degi strumenti cliccare Server-> Data Import.

Spuntare il casella "Import from Self-Contained file" e specificare il percorso di sample db (...../SAMPLEJava/db/sampledb.sql).

Alla voce "Default Target Schema" cliccare su "New" e scrivere "sampledb".

Andare quindi sulla scheda "Import Progress" (in alto a sinistra nella finestra di Data Import).

Cliccare su "Start Import" (in basso a destra). A questo punto si può eseguire il refresh.

Nel db ci sono due users:  	ADMIN	(username: 	admin, 	password: admin)
							USER 	(username: 	user, 	password: user )