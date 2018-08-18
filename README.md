# MVCPortlet-liferay
esempio di una portlet usando il framework mvcPortlet

il pattern mvc è così strutturato:
le view: view.jsp e edit_entry.jsp
il controller: PhaseAndLifecyclePortlet
ed il model : Entry.java


i file di configurazioni (scritti dal wizard di eclipse):
1.liferay-display.xml----> riporta l id della portlet e della categoria a cui questa portlet appartiene
2.liferay-plugin-package.properties  alcune propietà
3.liferay-portlet.xml definisce la portlet
4.portlet.xml definisce il controller
5. web.xml (non è iseito nulla, la configurazione è definita in portlet.xml)


Il funzionamento in breve:
all avvio la portlet esegue il render della pagina view.jsp; il metodo è stato sovrascritto e prima di chiamare il metodo render della classe base, imposta nella request un attributo che difatto è il been che viene passato alla vista.

Al bottone su questa vista è associato il rendering di un altra pagina jsp, questa pagina ha un form ed al form associa una action che salva il form.

l'esempio è stato preso da:
https://dev.liferay.com/develop/tutorials/-/knowledge_base/6-2/writing-your-first-liferay-application 
