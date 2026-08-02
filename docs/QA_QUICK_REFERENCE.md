# ⚡ QA Commands - Quick Reference Card

**Imprimir esta página o guardar como PDF para acceso rápido**

---

## 🎯 Comandos Más Usados

### ANÁLISIS Y PLANIFICACIÓN
```bash
# Analizar historia de usuario
orchestrator analyze-user-story --file "US-001.md"

# Generar plan de pruebas
orchestrator generate-test-plan --story "US-001" --coverage "comprehensive"

# Diseñar escenarios BDD
orchestrator design-scenarios --story "US-001" --bdd-format "gherkin"

# Leer requisitos de Jira
orchestrator read-jira-requirements --issue "US-001"
```

---

### DISEÑO Y DESARROLLO
```bash
# Crear test scripts POM
orchestrator design-test-scripts --story "US-001" --language "Java"

# Generar localizadores
orchestrator generate-locators --page "LoginPage" --scan-url "https://app.example.com"

# Generar datos de prueba
orchestrator generate-test-data --type "user-credentials" --count "10" --format "csv"
```

---

### EJECUCIÓN DE PRUEBAS
```bash
# Ejecutar por tag (Smoke tests)
orchestrator execute-tests --tag "@smoke" --environment "staging" --browser "chrome"

# Ejecutar todas las pruebas
orchestrator execute-all-tests --environment "staging" --parallel "true"

# Ejecutar múltiples tags en paralelo
orchestrator execute-tests --tag "@smoke,@login,@critical" --parallel "true" --threads "8"
```

---

### INSPECCIÓN Y DEBUG
```bash
# Inspeccionar elemento
orchestrator inspect-element --selector "button.login" --url "https://app.example.com"

# Capturar screenshot
orchestrator capture-screenshot --browser "chrome" --url "https://app.example.com"

# Obtener reporte
orchestrator get-latest-report --format "html" --output "reports/"
```

---

### INTEGRACIÓN Y REPORTE
```bash
# Disparar pipeline GitHub
orchestrator trigger-pipeline --workflow "test-automation" --branch "main" --wait "true"

# Crear evidencia en Jira
orchestrator create-jira-evidence --issue "QA-001" --report "test-results.json" --status "PASSED"
```

---

## 📋 Parámetros Más Comunes

| Parámetro | Valores | Por Defecto |
|---|---|---|
| `--environment` | staging, production, development | staging |
| `--browser` | chrome, firefox, safari, edge | chrome |
| `--language` | Java, Python, JavaScript | Java |
| `--format` | json, csv, html, xml, excel | markdown |
| `--parallel` | true, false | false |
| `--threads` | 1-16 | 4 |
| `--coverage` | basic, standard, comprehensive | standard |
| `--status` | PASSED, FAILED, SKIPPED | PASSED |

---

## 🚀 Flujo Típico (Copy-Paste Ready)

### Opción 1: Workflow Completo (4 días)

**Día 1 - Requisitos:**
```bash
orchestrator read-jira-requirements --issue "US-001"
orchestrator analyze-user-story --file "US-001.md"
orchestrator generate-test-plan --story "US-001" --coverage "comprehensive"
```

**Día 2 - Diseño:**
```bash
orchestrator design-scenarios --story "US-001" --bdd-format "gherkin"
orchestrator generate-test-data --type "user-credentials" --count "20" --format "json"
```

**Día 3 - Implementación:**
```bash
orchestrator design-test-scripts --story "US-001" --language "Java"
orchestrator generate-locators --page "LoginPage" --scan-url "https://app.example.com/login"
```

**Día 4 - Ejecución:**
```bash
orchestrator execute-tests --tag "@smoke,@login" --environment "staging" --parallel "true"
orchestrator get-latest-report --format "html" --output "target/reports/"
orchestrator create-jira-evidence --issue "US-001" --report "test-results.json" --status "PASSED"
```

---

### Opción 2: Ejecución Rápida (Smoke Tests)

```bash
# 1 minuto de setup
orchestrator execute-tests --tag "@smoke" --environment "staging" --parallel "true" --threads "8"

# Obtener resultados
orchestrator get-latest-report --format "html" --output "reports/"
```

---

### Opción 3: Debug de Elemento

```bash
# Inspeccionar
orchestrator inspect-element --selector "button.login" --url "https://app.example.com"

# Capturar
orchestrator capture-screenshot --browser "chrome" --url "https://app.example.com" --full-page "true"
```

---

## 🔥 Comandos de Emergencia

```bash
# Ejecutar SOLO pruebas críticas (más rápido)
orchestrator execute-tests --tag "@critical" --environment "staging" --browser "chrome"

# Disparar pipeline de producción
orchestrator trigger-pipeline --workflow "prod-tests" --branch "main" --environment "production" --wait "true"

# Generar evidencia urgente
orchestrator create-jira-evidence --issue "BUG-001" --report "latest" --status "FAILED" --comment "Defecto crítico encontrado"
```

---

## ✅ Checklist: Antes de Ejecutar Pruebas

- [ ] Requisitos leídos en Jira
- [ ] Plan de pruebas generado
- [ ] Escenarios BDD diseñados
- [ ] Scripts POM creados
- [ ] Datos de prueba generados
- [ ] Localizadores validados
- [ ] Ambiente correcto seleccionado
- [ ] Browser correcto seleccionado
- [ ] Tags correctos especificados

---

## 💡 Tips Pro

1. **Usa `--parallel "true"` siempre** - Acelera ejecución x4
2. **Copia comandos de esta tarjeta** - Menor chance de errores
3. **Verifica ambiente antes** - `--environment "staging"` vs `"production"`
4. **Tags múltiples son poderosos** - `--tag "@smoke,@login,@critical"`
5. **Captura screenshots** - Útil para debug
6. **Inspecciona elementos** - Si localizadores no funcionan

---

## 📞 Ayuda Rápida

```bash
# Ver todos los comandos disponibles
orchestrator --help

# Ver ayuda de comando específico
orchestrator execute-tests --help

# Ver versión actual
orchestrator --version

# Ver configuración actual
orchestrator config show
```

---

**Última actualización:** 2026-07-31  
**Versión:** 1.0  
**Impreso:** [Tu fecha aquí]
