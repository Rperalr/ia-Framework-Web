# 📋 Guía de Comandos para QA - Automation Framework

**Versión:** 1.0  
**Última actualización:** 2026-07-31  
**Propósito:** Proporcionar comandos CLI simples para solicitar acciones dentro del ciclo de pruebas automatizadas

---

## 📑 Tabla de Contenidos

1. [Introducción](#introducción)
2. [Tabla Rápida de Comandos](#tabla-rápida-de-comandos)
3. [Comandos Detallados](#comandos-detallados)
4. [Ejemplos de Uso en Flujo de Pruebas](#ejemplos-de-uso-en-flujo-de-pruebas)
5. [Sintaxis y Parámetros](#sintaxis-y-parámetros)
6. [Casos de Uso Comunes](#casos-de-uso-comunes)
7. [Solución de Problemas](#solución-de-problemas)

---

## 📌 Introducción

Los comandos de abajo permiten al equipo QA solicitar acciones específicas sin necesidad de escribir código o ejecutar comandos complejos. Cada frase natural se mapea a un comando específico que el **OrchestratorAgent** ejecutará automáticamente.

**Ejemplo:**
```
Usuario escriba:  "analizar historia de user"
Sistema ejecuta:  orchestrator analyze-user-story --file "US-001.md"
```

---

## ⚡ Tabla Rápida de Comandos

| Solicitud Natural | Comando CLI | Agente | Tiempo Aprox |
|---|---|---|---|
| Analizar historia de user | `orchestrator analyze-user-story` | TestPlanningAgent | 2-3 min |
| Desarrollar test scripts POM | `orchestrator design-test-scripts` | TestDesignerAgent | 5-10 min |
| Generar plan de pruebas | `orchestrator generate-test-plan` | TestPlanningAgent | 3-5 min |
| Diseñar escenarios de prueba | `orchestrator design-scenarios` | TestDesignerAgent | 5-7 min |
| Crear localizadores POM | `orchestrator generate-locators` | TestDesignerAgent | 3-5 min |
| Ejecutar pruebas por tag | `orchestrator execute-tests` | TestExecutionHandler | Variable |
| Ejecutar pruebas completas | `orchestrator execute-all-tests` | TestExecutionHandler | Variable |
| Crear evidencia en Jira | `orchestrator create-jira-evidence` | JiraTaskAgent | 2-3 min |
| Leer requisitos de Jira | `orchestrator read-jira-requirements` | JiraTaskAgent | 1-2 min |
| Disparar pipeline GitHub | `orchestrator trigger-pipeline` | GitHubActionsAgent | 5-15 min |
| Inspeccionar elemento en pantalla | `orchestrator inspect-element` | TestExecutionHandler | 1-2 min |
| Capturar screenshot | `orchestrator capture-screenshot` | TestExecutionHandler | 1 min |
| Obtener reporte de pruebas | `orchestrator get-latest-report` | TestExecutionHandler | 1-2 min |
| Generar datos de prueba | `orchestrator generate-test-data` | TestDesignerAgent | 2-4 min |

---

## 🎯 Comandos Detallados

### 1. Analizar Historia de Usuario

**Descripción:** Analiza una historia de usuario completa y extrae criterios de aceptación

**Comando:**
```bash
orchestrator analyze-user-story --file "US-001.md" --project "ProjectName"
```

**Parámetros:**
- `--file` (requerido): Ruta al archivo de la historia (Markdown o PDF)
- `--project` (opcional): Nombre del proyecto
- `--output` (opcional): Ruta de salida del análisis

**Ejemplo Completo:**
```bash
orchestrator analyze-user-story \
  --file "stories/US-001-Login.md" \
  --project "AutomationFramework" \
  --output "analysis/US-001-analysis.json"
```

**Resultado Esperado:**
```json
{
  "userStory": "US-001",
  "title": "Usuario inicia sesión con credenciales válidas",
  "criteria": [
    "El campo email debe aceptar formato válido",
    "El botón login debe estar habilitado",
    "Debe mostrar error si credenciales son inválidas"
  ],
  "scenarios": 3,
  "priority": "HIGH"
}
```

---

### 2. Desarrollar Test Scripts POM

**Descripción:** Crea los Page Object Models y scripts de prueba basados en la historia

**Comando:**
```bash
orchestrator design-test-scripts --story "US-001" --language "Java" --framework "POM"
```

**Parámetros:**
- `--story` (requerido): ID de la historia de usuario
- `--language` (opcional): Java, Python, JavaScript (por defecto: Java)
- `--framework` (opcional): POM, Cucumber, BDD (por defecto: POM)
- `--output-path` (opcional): Directorio donde generar scripts

**Ejemplo Completo:**
```bash
orchestrator design-test-scripts \
  --story "US-001" \
  --language "Java" \
  --framework "POM" \
  --output-path "src/test/java/pages"
```

**Genera Automáticamente:**
```
src/test/java/pages/
├── LoginPage.java
├── HomePage.java
└── DashboardPage.java

src/test/java/tests/
├── LoginTest.java
└── LoginPageTest.java
```

---

### 3. Generar Plan de Pruebas

**Descripción:** Crea un plan detallado de pruebas basado en la historia

**Comando:**
```bash
orchestrator generate-test-plan --story "US-001" --coverage "comprehensive"
```

**Parámetros:**
- `--story` (requerido): ID de la historia
- `--coverage` (opcional): basic, standard, comprehensive (por defecto: standard)
- `--format` (opcional): markdown, excel, json (por defecto: markdown)

**Ejemplo:**
```bash
orchestrator generate-test-plan \
  --story "US-001" \
  --coverage "comprehensive" \
  --format "markdown"
```

**Genera:**
```
test-plan-US-001.md
├── Objetivo
├── Alcance
├── Escenarios de Prueba
├── Datos de Prueba
├── Criterios de Aceptación
├── Riesgos
└── Estimación de Esfuerzo
```

---

### 4. Diseñar Escenarios de Prueba

**Descripción:** Crea escenarios Gherkin (BDD) basados en la historia

**Comando:**
```bash
orchestrator design-scenarios --story "US-001" --bdd-format "gherkin"
```

**Parámetros:**
- `--story` (requerido): ID de la historia
- `--bdd-format` (opcional): gherkin, robot, cucumber
- `--language` (opcional): es, en, pt

**Ejemplo Completo:**
```bash
orchestrator design-scenarios \
  --story "US-001" \
  --bdd-format "gherkin" \
  --language "es"
```

**Genera Feature File:**
```gherkin
# language: es
Característica: Login de Usuario
  Como usuario
  Quiero iniciar sesión
  Para acceder a mis datos

  Escenario: Login exitoso con credenciales válidas
    Dado que estoy en la página de login
    Cuando ingreso usuario "test@example.com"
    Y ingreso contraseña "Password123"
    Y hago clic en "Iniciar Sesión"
    Entonces debo ver el dashboard
```

---

### 5. Crear Localizadores POM

**Descripción:** Genera automáticamente localizadores XPath, CSS, ID para elementos

**Comando:**
```bash
orchestrator generate-locators --page "LoginPage" --browser "chrome"
```

**Parámetros:**
- `--page` (requerido): Nombre de la página POM
- `--browser` (opcional): chrome, firefox, safari, edge
- `--scan-url` (opcional): URL para escanear elementos automáticamente
- `--format` (opcional): java, python, json

**Ejemplo:**
```bash
orchestrator generate-locators \
  --page "LoginPage" \
  --browser "chrome" \
  --scan-url "https://app.example.com/login" \
  --format "java"
```

**Genera LoginPage.java:**
```java
public class LoginPage {
    // Localizadores
    private By emailInput = By.xpath("//input[@id='email']");
    private By passwordInput = By.id("password");
    private By loginButton = By.cssSelector("button.btn-login");
    private By errorMessage = By.xpath("//div[@class='error-message']");
    
    // Métodos de acción
    public void enterEmail(String email) { /* ... */ }
    public void enterPassword(String password) { /* ... */ }
    public void clickLogin() { /* ... */ }
    public String getErrorMessage() { /* ... */ }
}
```

---

### 6. Ejecutar Pruebas por Tag

**Descripción:** Ejecuta pruebas específicas basadas en tags

**Comando:**
```bash
orchestrator execute-tests --tag "@smoke" --environment "staging" --browser "chrome"
```

**Parámetros:**
- `--tag` (requerido): Tag a ejecutar (@smoke, @regression, @critical)
- `--environment` (opcional): staging, production, development
- `--browser` (opcional): chrome, firefox, safari, edge
- `--parallel` (opcional): true/false (por defecto: false)
- `--threads` (opcional): Número de threads paralelos

**Ejemplo Completo:**
```bash
orchestrator execute-tests \
  --tag "@smoke,@login" \
  --environment "staging" \
  --browser "chrome" \
  --parallel "true" \
  --threads "4"
```

**Ejecuta:**
```
✅ Iniciando Maven con perfil específico
📊 Ejecutando 12 pruebas con @smoke tag
⏱️  Tiempo total: 2 min 34 seg
📈 Resultados: 12 PASSED, 0 FAILED, 0 SKIPPED
```

---

### 7. Ejecutar Todas las Pruebas

**Descripción:** Ejecuta la suite completa de pruebas

**Comando:**
```bash
orchestrator execute-all-tests --environment "staging" --browser "chrome"
```

**Parámetros:**
- `--environment` (opcional): staging, production, development (por defecto: staging)
- `--browser` (opcional): chrome, firefox, safari, edge (por defecto: chrome)
- `--parallel` (opcional): true/false (por defecto: true)
- `--threads` (opcional): Número de threads (por defecto: 4)

**Ejemplo:**
```bash
orchestrator execute-all-tests \
  --environment "staging" \
  --browser "chrome" \
  --parallel "true" \
  --threads "8"
```

---

### 8. Crear Evidencia en Jira

**Descripción:** Publica resultados y evidencia de pruebas en una tarea Jira

**Comando:**
```bash
orchestrator create-jira-evidence --issue "QA-001" --report "test-results.json" --status "PASSED"
```

**Parámetros:**
- `--issue` (requerido): ID de la tarea Jira
- `--report` (requerido): Ruta al archivo de resultados
- `--status` (requerido): PASSED, FAILED, SKIPPED
- `--attachments` (opcional): Rutas a screenshots/logs separadas por coma
- `--comment` (opcional): Comentario adicional

**Ejemplo Completo:**
```bash
orchestrator create-jira-evidence \
  --issue "QA-001" \
  --report "target/reports/test-results.json" \
  --status "PASSED" \
  --attachments "target/screenshots/login.png,target/logs/test.log" \
  --comment "Pruebas de login completadas exitosamente"
```

---

### 9. Leer Requisitos de Jira

**Descripción:** Extrae criterios de aceptación y requisitos de una tarea Jira

**Comando:**
```bash
orchestrator read-jira-requirements --issue "US-001"
```

**Parámetros:**
- `--issue` (requerido): ID de la tarea/historia
- `--include-subtasks` (opcional): true/false (por defecto: true)
- `--output` (opcional): Ruta de salida en JSON

**Ejemplo:**
```bash
orchestrator read-jira-requirements \
  --issue "US-001" \
  --include-subtasks "true" \
  --output "jira-requirements.json"
```

---

### 10. Disparar Pipeline GitHub

**Descripción:** Dispara un workflow de GitHub Actions

**Comando:**
```bash
orchestrator trigger-pipeline --workflow "test-automation" --branch "main" --environment "staging"
```

**Parámetros:**
- `--workflow` (requerido): Nombre del workflow
- `--branch` (requerido): Rama a ejecutar
- `--environment` (opcional): staging, production
- `--wait` (opcional): true/false - esperar a que termine
- `--timeout` (opcional): Segundos para timeout (por defecto: 1800)

**Ejemplo:**
```bash
orchestrator trigger-pipeline \
  --workflow "test-automation" \
  --branch "main" \
  --environment "staging" \
  --wait "true" \
  --timeout "1800"
```

---

### 11. Inspeccionar Elemento en Pantalla

**Descripción:** Inspecciona un elemento web e obtiene sus propiedades

**Comando:**
```bash
orchestrator inspect-element --selector "button.login" --browser "chrome" --url "https://app.example.com"
```

**Parámetros:**
- `--selector` (requerido): CSS selector o XPath del elemento
- `--browser` (opcional): chrome, firefox, safari
- `--url` (requerido): URL a navegar

**Resultado:**
```json
{
  "element": "button.login",
  "tagName": "button",
  "text": "Iniciar Sesión",
  "attributes": {
    "class": "btn-primary",
    "id": "loginBtn",
    "type": "submit"
  },
  "css": {
    "display": "block",
    "backgroundColor": "#007bff",
    "color": "white"
  },
  "xpath": "//button[@id='loginBtn']",
  "cssSelector": "button.btn-primary"
}
```

---

### 12. Capturar Screenshot

**Descripción:** Toma una captura de pantalla de la aplicación

**Comando:**
```bash
orchestrator capture-screenshot --browser "chrome" --url "https://app.example.com" --output "screenshot.png"
```

**Parámetros:**
- `--browser` (requerido): chrome, firefox, safari, edge
- `--url` (requerido): URL a capturar
- `--output` (opcional): Ruta de salida (por defecto: screenshot-{timestamp}.png)
- `--full-page` (opcional): true/false - capturar página completa

**Ejemplo:**
```bash
orchestrator capture-screenshot \
  --browser "chrome" \
  --url "https://app.example.com/dashboard" \
  --output "target/screenshots/dashboard.png" \
  --full-page "true"
```

---

### 13. Obtener Reporte de Pruebas

**Descripción:** Genera o recupera el reporte más reciente de pruebas

**Comando:**
```bash
orchestrator get-latest-report --format "html" --output "reports/"
```

**Parámetros:**
- `--format` (opcional): html, json, xml, pdf (por defecto: html)
- `--output` (requerido): Directorio de salida
- `--include-logs` (opcional): true/false (por defecto: true)

**Ejemplo:**
```bash
orchestrator get-latest-report \
  --format "html" \
  --output "target/reports/" \
  --include-logs "true"
```

**Genera:**
```
target/reports/
├── test-report.html          (Reporte visual)
├── test-results.json         (Datos estructurados)
├── logs.txt                  (Logs detallados)
└── screenshots/              (Capturas de pruebas)
    ├── login-success.png
    ├── login-fail.png
    └── dashboard-view.png
```

---

### 14. Generar Datos de Prueba

**Descripción:** Genera automáticamente datos de prueba válidos

**Comando:**
```bash
orchestrator generate-test-data --type "user-credentials" --count "10" --format "csv"
```

**Parámetros:**
- `--type` (requerido): user-credentials, products, addresses, emails, etc.
- `--count` (opcional): Cantidad de registros (por defecto: 10)
- `--format` (opcional): csv, json, excel, xml
- `--output` (requerido): Ruta de salida

**Ejemplo Completo:**
```bash
orchestrator generate-test-data \
  --type "user-credentials" \
  --count "50" \
  --format "csv" \
  --output "test-data/users.csv"
```

**Genera:**
```csv
email,password,firstName,lastName,role
user1@test.com,Pass123!@,John,Doe,admin
user2@test.com,Pass123!@,Jane,Smith,user
user3@test.com,Pass123!@,Bob,Johnson,tester
...
```

---

## 📊 Ejemplos de Uso en Flujo de Pruebas

### Flujo Completo: De Requisitos a Ejecución

```bash
# DÍA 1: Recibir requisitos
orchestrator read-jira-requirements --issue "US-001" --output "requirements.json"

# Analizar historia
orchestrator analyze-user-story --file "US-001.md" --project "AutomationFramework"

# Generar plan de pruebas
orchestrator generate-test-plan --story "US-001" --coverage "comprehensive"

# Diseñar escenarios BDD
orchestrator design-scenarios --story "US-001" --bdd-format "gherkin" --language "es"

# Generar datos de prueba
orchestrator generate-test-data --type "user-credentials" --count "20" --format "json" --output "test-data/users.json"

# DÍA 2: Implementar pruebas
orchestrator design-test-scripts --story "US-001" --language "Java" --framework "POM"

orchestrator generate-locators --page "LoginPage" --browser "chrome" --scan-url "https://app.example.com/login"

# DÍA 3: Ejecutar y reportar
orchestrator execute-tests --tag "@smoke,@login" --environment "staging" --browser "chrome" --parallel "true"

orchestrator get-latest-report --format "html" --output "target/reports/"

orchestrator capture-screenshot --browser "chrome" --url "https://app.example.com/dashboard" --output "screenshots/dashboard.png"

# DÍA 4: Reportar en Jira
orchestrator create-jira-evidence \
  --issue "US-001" \
  --report "target/reports/test-results.json" \
  --status "PASSED" \
  --attachments "screenshots/dashboard.png,target/logs/test.log"
```

---

## 🔧 Sintaxis y Parámetros

### Formato General

```bash
orchestrator <comando> --parametro1 "valor1" --parametro2 "valor2"
```

### Tipos de Parámetros

| Tipo | Formato | Ejemplo |
|---|---|---|
| Texto | `--param "valor"` | `--story "US-001"` |
| Número | `--param 10` | `--threads 4` |
| Booleano | `--param "true"` o `--param "false"` | `--parallel "true"` |
| Ruta | `--param "path/to/file"` | `--file "stories/US-001.md"` |
| Múltiple | `--param "val1,val2,val3"` | `--tag "@smoke,@login,@critical"` |

### Valores por Defecto

- **environment:** staging
- **browser:** chrome
- **language:** Java
- **framework:** POM
- **parallel:** false
- **threads:** 4
- **coverage:** standard
- **format:** markdown

---

## 🎯 Casos de Uso Comunes

### Caso 1: QA Recibe Nueva Historia
```bash
# Paso 1: Leer requisitos de Jira
orchestrator read-jira-requirements --issue "US-042"

# Paso 2: Analizar historia
orchestrator analyze-user-story --file "stories/US-042.md"

# Paso 3: Generar plan
orchestrator generate-test-plan --story "US-042" --coverage "comprehensive"
```

### Caso 2: Implementar Pruebas Nuevas
```bash
# Paso 1: Diseñar escenarios
orchestrator design-scenarios --story "US-042" --bdd-format "gherkin"

# Paso 2: Generar scripts POM
orchestrator design-test-scripts --story "US-042" --language "Java"

# Paso 3: Generar localizadores
orchestrator generate-locators --page "NewFeaturePage" --scan-url "https://app.example.com/feature"

# Paso 4: Generar datos
orchestrator generate-test-data --type "user-credentials" --count "10" --format "csv"
```

### Caso 3: Ejecutar Pruebas Completas
```bash
# Ejecutar todas las pruebas
orchestrator execute-all-tests --environment "staging" --browser "chrome" --parallel "true"

# Obtener reporte
orchestrator get-latest-report --format "html" --output "reports/"

# Publicar evidencia
orchestrator create-jira-evidence --issue "QA-100" --report "reports/test-results.json" --status "PASSED"
```

### Caso 4: Debug de Elemento Específico
```bash
# Inspeccionar elemento
orchestrator inspect-element --selector "button.submit" --url "https://app.example.com/form"

# Capturar pantalla del elemento
orchestrator capture-screenshot --browser "chrome" --url "https://app.example.com/form" --output "debug-screenshot.png"
```

### Caso 5: Ejecución Urgente (Solo Smoke Tests)
```bash
orchestrator execute-tests \
  --tag "@smoke" \
  --environment "staging" \
  --browser "chrome" \
  --parallel "true" \
  --threads "8"
```

---

## ⚠️ Solución de Problemas

### Error: Comando no reconocido
```bash
# Solución: Verificar sintaxis
orchestrator --help                    # Ver todos los comandos
orchestrator <comando> --help          # Ver ayuda de comando específico
```

### Error: Parámetro requerido faltante
```bash
# Asegúrate de incluir parámetros requeridos
orchestrator execute-tests --tag "@smoke"  # ✅ Correcto
orchestrator execute-tests                 # ❌ Falta --tag
```

### Error: Ruta no encontrada
```bash
# Verifica rutas relativas
orchestrator analyze-user-story --file "stories/US-001.md"  # Desde raíz del proyecto
# o usa rutas absolutas
orchestrator analyze-user-story --file "C:/proyecto/stories/US-001.md"
```

### Error: Credenciales de Jira/GitHub inválidas
```bash
# Configura credenciales en archivo de configuración
# Editar: ai-orchestration/config/orchestration.yml

jira:
  url: "https://jira.example.com"
  username: "tu-usuario"
  token: "tu-token-api"

github:
  token: "tu-token-github"
```

---

## 📞 Soporte y Contacto

Para problemas o sugerencias:
- **Documentación:** Ver README.md en ai-orchestration/
- **Logs:** Revisar `logs/automation-orchestrator.log`
- **Equipo:** Contactar al equipo de DevOps/Automation

---

**Última revisión:** 2026-07-31  
**Versión:** 1.0  
**Estado:** Producción
