🎯 Mapeo Rápido - Frase Natural → 

Comando: Solicitud del QA  Comando CLI  "
Analizar historia de user"  orchestrator analyze-user-story --file "US-001.md"
"Desarrollar test scripts POM"  orchestrator design-test-scripts --story "US-001"
"Generar plan de pruebas"  orchestrator generate-test-plan --story "US-001"  
"Diseñar escenarios BDD"  orchestrator design-scenarios --story "US-001"  
"Crear localizadores POM"  orchestrator generate-locators --page "LoginPage"  
"Ejecutar smoke tests"  orchestrator execute-tests --tag "@smoke"  
"Ejecutar todas las pruebas"  orchestrator execute-all-tests --parallel 
"true"  "Crear evidencia en Jira"  orchestrator create-jira-evidence --issue "QA-001