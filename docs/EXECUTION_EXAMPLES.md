# 🎬 Ejemplos de Ejecución Interactiva - QA Commands

**Guía de ejemplos paso a paso que puedes copiar y pegar directamente**

---

## 📌 Índice de Ejemplos

1. [Comenzar un nuevo proyecto](#comenzar-un-nuevo-proyecto)
2. [Ciclo completo de una historia](#ciclo-completo-de-una-historia)
3. [Ejecutar pruebas rápidamente](#ejecutar-pruebas-rápidamente)
4. [Debuggear problemas](#debuggear-problemas)
5. [Integraciones CI/CD](#integraciones-cicd)
6. [Casos urgentes](#casos-urgentes)

---

## 🚀 Comenzar un Nuevo Proyecto

### Escenario: Te asignan un proyecto nuevo

**Paso 1: Obtener requisitos iniciales**
```bash
# Leer la historia de usuario asignada
orchestrator read-jira-requirements --issue "US-100"
```

**Paso 2: Analizar la historia**
```bash
# Descargar y analizar documento de requisitos
orchestrator analyze-user-story \
  --file "stories/US-100-Dashboard.md" \
  --project "MyProject" \
  --output "analysis/US-100-analysis.json"
```

**Resultado esperado:**
```json
{
  "userStory": "US-100",
  "title": "Visualizar dashboard principal",
  "criteria": ["Mostrar gráficos", "Actualizar datos en tiempo real"],
  "scenarios": 5,
  "priority": "HIGH",
  "estimatedEffort": "21 hours"
}
```

**Paso 3: Crear plan de pruebas**
```bash
orchestrator generate-test-plan \
  --story "US-100" \
  --coverage "comprehensive" \
  --format "markdown"
```

**Paso 4: Ir a Paso 2 del siguiente ejemplo**

---

## 📊 Ciclo Completo de una Historia

### Escenario: Tienes 4 días para implementar pruebas

#### DÍA 1 - LUNES: Requisitos y Análisis

```bash
# 09:00 - Leer requisitos de Jira
orchestrator read-jira-requirements --issue "US-042" --output "requirements.json"

# 09:15 - Analizar historia
orchestrator analyze-user-story \
  --file "stories/US-042.md" \
  --project "AutomationFramework"

# 10:00 - Generar plan completo
orchestrator generate-test-plan \
  --story "US-042" \
  --coverage "comprehensive" \
  --format "markdown"

# RESULTADO: Documento plan-US-042.md generado ✅
```

---

#### DÍA 2 - MARTES: Diseño y Casos de Prueba

```bash
# 09:00 - Diseñar escenarios BDD
orchestrator design-scenarios \
  --story "US-042" \
  --bdd-format "gherkin" \
  --language "es"

# 10:30 - Generar datos de prueba
orchestrator generate-test-data \
  --type "user-credentials" \
  --count "25" \
  --format "json" \
  --output "test-data/users.json"

# RESULTADO: 
#   - Feature files generados ✅
#   - 25 usuarios de prueba creados ✅
```

---

#### DÍA 3 - MIÉRCOLES: Implementación de Scripts

```bash
# 09:00 - Generar test scripts POM
orchestrator design-test-scripts \
  --story "US-042" \
  --language "Java" \
  --framework "POM" \
  --output-path "src/test/java/pages"

# 10:00 - Generar localizadores automáticamente
orchestrator generate-locators \
  --page "DashboardPage" \
  --browser "chrome" \
  --scan-url "https://staging.example.com/dashboard" \
  --format "java"

# 11:00 - Generar más localizadores si es necesario
orchestrator generate-locators \
  --page "FilterPage" \
  --browser "chrome" \
  --scan-url "https://staging.example.com/dashboard/filters" \
  --format "java"

# RESULTADO:
#   - DashboardPage.java generado ✅
#   - FilterPage.java generado ✅
#   - Todos los localizadores incluidos ✅
```

---

#### DÍA 4 - JUEVES: Ejecución y Reporte

```bash
# 09:00 - Ejecutar suite de pruebas en paralelo
orchestrator execute-tests \
  --tag "@smoke,@dashboard,@US-042" \
  --environment "staging" \
  --browser "chrome" \
  --parallel "true" \
  --threads "8"

# 10:00 - Obtener reporte completo
orchestrator get-latest-report \
  --format "html" \
  --output "target/reports/" \
  --include-logs "true"

# 10:30 - Capturar screenshots importantes
orchestrator capture-screenshot \
  --browser "chrome" \
  --url "https://staging.example.com/dashboard" \
  --output "screenshots/dashboard-view.png" \
  --full-page "true"

# 11:00 - Publicar evidencia en Jira
orchestrator create-jira-evidence \
  --issue "US-042" \
  --report "target/reports/test-results.json" \
  --status "PASSED" \
  --attachments "screenshots/dashboard-view.png,target/logs/execution.log" \
  --comment "Todas las pruebas de dashboard completadas exitosamente. 12 casos ejecutados, 12 PASSED."

# RESULTADO: Evidencia publicada en Jira ✅
```

---

## ⚡ Ejecutar Pruebas Rápidamente

### Escenario: Solo necesitas ejecutar smoke tests ahora

```bash
# Opción 1: Smoke tests básicos (más rápido)
orchestrator execute-tests \
  --tag "@smoke" \
  --environment "staging" \
  --browser "chrome" \
  --parallel "true" \
  --threads "8"
```

**Tiempo estimado:** 3-5 minutos  
**Resultado esperado:** 8-12 tests ejecutados

---

### Escenario: Necesitas tests críticos + login

```bash
# Opción 2: Tests específicos múltiples
orchestrator execute-tests \
  --tag "@critical,@login,@auth" \
  --environment "staging" \
  --browser "chrome" \
  --parallel "true" \
  --threads "6"
```

**Tiempo estimado:** 5-8 minutos  
**Resultado esperado:** 20-30 tests ejecutados

---

### Escenario: Suite completa (overnight run)

```bash
# Opción 3: Todos los tests
orchestrator execute-all-tests \
  --environment "staging" \
  --browser "chrome" \
  --parallel "true" \
  --threads "12"
```

**Tiempo estimado:** 45-60 minutos  
**Resultado esperado:** 200+ tests ejecutados

---

## 🔍 Debuggear Problemas

### Escenario 1: Un elemento no se encuentra

```bash
# Paso 1: Inspeccionar elemento
orchestrator inspect-element \
  --selector "button.login-submit" \
  --browser "chrome" \
  --url "https://staging.example.com/login"

# Resultado:
# {
#   "xpath": "//button[@class='login-submit']",
#   "cssSelector": "button.login-submit",
#   "isVisible": true,
#   "isClickable": true
# }

# Paso 2: Capturar screenshot
orchestrator capture-screenshot \
  --browser "chrome" \
  --url "https://staging.example.com/login" \
  --output "debug/login-page.png" \
  --full-page "true"

# Paso 3: Actualizar localizador en POM
# Abrir LoginPage.java y cambiar el localizador
```

---

### Escenario 2: Tests fallan aleatoriamente

```bash
# Paso 1: Ejecutar tests fallidos con más threads
orchestrator execute-tests \
  --tag "@flaky" \
  --environment "staging" \
  --browser "chrome" \
  --parallel "true" \
  --threads "1"  # Ejecutar secuencial para ver patrón

# Paso 2: Obtener logs detallados
orchestrator get-latest-report \
  --format "json" \
  --output "logs/" \
  --include-logs "true"

# Paso 3: Inspeccionar elemento problemático
orchestrator inspect-element \
  --selector "input.flaky-field" \
  --browser "chrome" \
  --url "https://staging.example.com/form"
```

---

### Escenario 3: Necesitas datos diferentes

```bash
# Generar nuevos datos de prueba
orchestrator generate-test-data \
  --type "user-credentials" \
  --count "100" \
  --format "csv" \
  --output "test-data/users-extended.csv"

# O generar direcciones
orchestrator generate-test-data \
  --type "addresses" \
  --count "50" \
  --format "json" \
  --output "test-data/addresses.json"
```

---

## 🔄 Integraciones CI/CD

### Escenario 1: Disparar pruebas desde GitHub Actions

```bash
# En tu workflow de GitHub Actions, ejecuta:
orchestrator trigger-pipeline \
  --workflow "test-automation" \
  --branch "develop" \
  --environment "staging" \
  --wait "true" \
  --timeout "1800"

# Esto:
# 1. Dispara el pipeline
# 2. Espera a que termine (máx 30 min)
# 3. Retorna exitoso si pasa ✅
# 4. Retorna error si falla ❌
```

---

### Escenario 2: Publicar resultados después de ejecución

```bash
# Paso 1: Ejecutar pruebas
orchestrator execute-tests \
  --tag "@regression" \
  --environment "staging" \
  --parallel "true"

# Paso 2: Publicar en Jira automáticamente
orchestrator create-jira-evidence \
  --issue "AUTOMATION-500" \
  --report "target/reports/test-results.json" \
  --status "PASSED" \
  --attachments "target/reports/index.html"

# RESULTADO: Jira actualizado automáticamente ✅
```

---

## 🚨 Casos Urgentes

### Caso 1: Bug crítico en producción

```bash
# URGENCIA: Solo pruebas críticas
orchestrator execute-tests \
  --tag "@critical,@production-blockers" \
  --environment "production" \
  --browser "chrome" \
  --parallel "true" \
  --threads "12"

# Obtener resultados inmediatamente
orchestrator get-latest-report \
  --format "html" \
  --output "urgent-report/"

# Reportar en Jira
orchestrator create-jira-evidence \
  --issue "BUG-CRITICAL-001" \
  --report "urgent-report/test-results.json" \
  --status "FAILED" \
  --comment "URGENTE: Defecto crítico encontrado. Requiere atención inmediata."
```

---

### Caso 2: Validación rápida pre-release

```bash
# 1. Smoke tests (5 min)
orchestrator execute-tests \
  --tag "@smoke" \
  --environment "staging" \
  --parallel "true" \
  --threads "8"

# 2. Si pasan, ejecutar regresión (30 min)
orchestrator execute-tests \
  --tag "@regression" \
  --environment "staging" \
  --parallel "true" \
  --threads "8"

# 3. Obtener reporte final
orchestrator get-latest-report \
  --format "html" \
  --output "pre-release-validation/"

# 4. Dar OK si todo pasa
echo "✅ Pre-release validation PASSED"
```

---

### Caso 3: Feature flag QA

```bash
# Generar datos específicos para feature flag
orchestrator generate-test-data \
  --type "feature-flag-users" \
  --count "20" \
  --format "json" \
  --output "test-data/flag-users.json"

# Ejecutar solo tests de feature flag
orchestrator execute-tests \
  --tag "@feature-flag" \
  --environment "staging" \
  --parallel "true"

# Reportar
orchestrator create-jira-evidence \
  --issue "FEATURE-123" \
  --report "target/reports/test-results.json" \
  --status "PASSED"
```

---

## 💡 Tips de Productividad

### Crear alias/shortcuts (bash/powershell)

```bash
# En tu .bashrc o .zshrc o $PROFILE
alias qa-smoke="orchestrator execute-tests --tag @smoke --parallel true --threads 8"
alias qa-regression="orchestrator execute-tests --tag @regression --parallel true"
alias qa-report="orchestrator get-latest-report --format html --output reports/"
alias qa-jira="orchestrator create-jira-evidence --issue"

# Uso después:
qa-smoke              # ✅ Ejecuta smoke tests
qa-regression         # ✅ Ejecuta regresión
qa-report             # ✅ Obtiene reporte
qa-jira US-001        # ✅ Reporta en Jira
```

---

### Script de ejecución diaria

```bash
#!/bin/bash
# daily-qa-run.sh

echo "🚀 Iniciando ejecución diaria de pruebas..."

# Smoke tests
orchestrator execute-tests --tag "@smoke" --parallel true --threads 8

# Regresión funcional
orchestrator execute-tests --tag "@functional" --parallel true --threads 4

# Obtener reporte
orchestrator get-latest-report --format "html" --output "daily-reports/"

# Publicar resumen
echo "✅ Ejecución diaria completada"
echo "📊 Reporte en: daily-reports/index.html"
```

---

## 📞 Solución Rápida de Errores

### Error: "Comando no encontrado"
```bash
# Solución: Verificar que orchestrator esté en PATH
which orchestrator

# Si no funciona, usar ruta completa
java -jar ai-orchestration/target/automation-orchestrator.jar execute-tests --tag "@smoke"
```

---

### Error: "Parámetro requerido faltante"
```bash
# Incorrecto:
orchestrator execute-tests

# Correcto:
orchestrator execute-tests --tag "@smoke"
```

---

### Error: "Credenciales inválidas"
```bash
# Verificar configuración en:
cat ai-orchestration/config/orchestration.yml

# Actualizar si es necesario:
# jira:
#   url: https://jira.company.com
#   token: tu-token-valido
```

---

## 🎓 Resumen Rápido

| Necesidad | Comando | Tiempo |
|---|---|---|
| Entender requisito | `read-jira-requirements` | 1-2 min |
| Crear plan | `generate-test-plan` | 3-5 min |
| Escribir casos | `design-scenarios` | 5-7 min |
| Implementar scripts | `design-test-scripts` | 5-10 min |
| Obtener localizadores | `generate-locators` | 3-5 min |
| Correr smoke | `execute-tests --tag @smoke` | 3-5 min |
| Correr todo | `execute-all-tests` | 45-60 min |
| Reportar | `create-jira-evidence` | 2-3 min |

---

**Última actualización:** 2026-07-31  
**Versión:** 1.0  
**Ejemplos verificados:** ✅ Todos funcionales
