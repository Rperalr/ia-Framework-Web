# 🎯 COMANDOS RÁPIDOS - EJECUCIÓN DE TESTS EN ORDEN

## 📋 RESUMEN EJECUTIVO

Este archivo contiene todos los comandos que necesitas para ejecutar los tests en el orden correcto.

---

## ⚡ COMANDOS MÁS USADOS

### 1️⃣ **EJECUTAR PRIMER PASO - LOGIN (Requerido Siempre)**

```bash
orchestrator execute-tests --tag "@login" --environment "staging" --browser "chrome"
```

**Código Simplificado:**
```bash
orch test @login
```

**Qué hace:** Verifica que el login funciona correctamente. SIEMPRE ejecutar primero.

---

### 2️⃣ **EJECUTAR UPLOAD FOTO (Después de Login)**

```bash
orchestrator execute-tests --tag "@uploadpic" --environment "staging" --browser "chrome"
```

**Código Simplificado:**
```bash
orch test @uploadpic
```

---

### 3️⃣ **EJECUTAR CANCELAR FOTO (Después de Upload)**

```bash
orchestrator execute-tests --tag "@cancelpic" --environment "staging" --browser "chrome"
```

**Código Simplificado:**
```bash
orch test @cancelpic
```

---

### 4️⃣ **EJECUTAR ELIMINAR FOTO (Después de Cancelar)**

```bash
orchestrator execute-tests --tag "@deletepic" --environment "staging" --browser "chrome"
```

**Código Simplificado:**
```bash
orch test @deletepic
```

---

### 5️⃣ **EJECUTAR RADIOLOGÍA (Módulo 1)**

```bash
orchestrator execute-tests --tag "@radiologia" --environment "staging" --browser "chrome"
```

**Código Simplificado:**
```bash
orch test @radiologia
```

---

### 6️⃣ **EJECUTAR TOMOGRAFÍA (Módulo 2)**

```bash
orchestrator execute-tests --tag "@tomografia" --environment "staging" --browser "chrome"
```

**Código Simplificado:**
```bash
orch test @tomografia
```

---

### 7️⃣ **EJECUTAR ULTRASONIDO (Módulo 3)**

```bash
orchestrator execute-tests --tag "@ultrasound" --environment "staging" --browser "chrome"
```

**Código Simplificado:**
```bash
orch test @ultrasound
```

---

## 🚀 COMANDOS PARA SUITE COMPLETA

### **Ejecutar TODA la Suite en Orden (7 Tests)**

```bash
orchestrator execute-tests \
  --tag "@priority-01 or @priority-02 or @priority-03 or @priority-04 or @priority-05 or @priority-06 or @priority-07" \
  --environment "staging" \
  --browser "chrome" \
  --report "html"
```

**Alias Simplificado:**
```bash
orch test-suite complete
```

**Tiempo Estimado:** 25-35 minutos

---

### **Ejecutar SOLO Funcionalidad de Fotos (4 Tests)**

```bash
orchestrator execute-tests \
  --tag "@profile-management" \
  --environment "staging" \
  --browser "chrome"
```

**Alias Simplificado:**
```bash
orch test-group photos
```

**Tiempo Estimado:** 8-12 minutos

---

### **Ejecutar SOLO Diagnósticos (3 Tests)**

```bash
orchestrator execute-tests \
  --tag "@diagnostics" \
  --environment "staging" \
  --browser "chrome"
```

**Alias Simplificado:**
```bash
orch test-group diagnostics
```

**Tiempo Estimado:** 15-20 minutos

---

### **Ejecutar SOLO Tests Críticos (Login)**

```bash
orchestrator execute-tests \
  --tag "@critical and @authentication" \
  --environment "staging" \
  --browser "chrome"
```

**Alias Simplificado:**
```bash
orch test-critical
```

**Tiempo Estimado:** 2-3 minutos

---

### **Ejecutar Tests de Smoke (Base + Fotos)**

```bash
orchestrator execute-tests \
  --tag "@smoke" \
  --environment "staging" \
  --browser "chrome"
```

**Alias Simplificado:**
```bash
orch test-smoke
```

**Tiempo Estimado:** 10-15 minutos

---

## 🌍 COMANDOS POR AMBIENTE

### **Ambiente: STAGING**

```bash
orchestrator execute-tests --tag "@login" --environment "staging" --browser "chrome"
```

### **Ambiente: PRODUCTION**

```bash
orchestrator execute-tests --tag "@login" --environment "production" --browser "chrome"
```

### **Ambiente: LOCAL/DEV**

```bash
orchestrator execute-tests --tag "@login" --environment "development" --browser "chrome"
```

---

## 🌐 COMANDOS POR NAVEGADOR

### **Chrome (Recomendado)**

```bash
orchestrator execute-tests --tag "@login" --browser "chrome"
```

### **Firefox**

```bash
orchestrator execute-tests --tag "@login" --browser "firefox"
```

### **Safari**

```bash
orchestrator execute-tests --tag "@login" --browser "safari"
```

### **Edge**

```bash
orchestrator execute-tests --tag "@login" --browser "edge"
```

---

## 📊 FLUJO DE EJECUCIÓN RECOMENDADO (DÍA A DÍA)

### **MAÑANA - Verificación Base**

```bash
# 1. Verificar Login
orchestrator execute-tests --tag "@login" --environment "staging"

# Si Login pasa ✅
# 2. Ejecutar Smoke Tests
orchestrator execute-tests --tag "@smoke" --environment "staging"
```

**Tiempo:** 12-18 minutos

---

### **MEDIODÍA - Funcionalidad de Fotos**

```bash
# Después que Login pasó ✅
orchestrator execute-tests --tag "@profile-management" --environment "staging"
```

**Tiempo:** 8-12 minutos

---

### **TARDE - Módulos Diagnósticos**

```bash
# Después que Fotos pasaron ✅
orchestrator execute-tests --tag "@diagnostics" --environment "staging"
```

**Tiempo:** 15-20 minutos

---

### **NOCHE - Suite Completa (Opcional)**

```bash
# Ejecutar todo junto
orchestrator execute-tests --tag "@suite-complete" --environment "staging"
```

**Tiempo:** 25-35 minutos

---

## ✨ CASOS ESPECIALES

### **Ejecutar UN Test Específico**

```bash
# Login solamente
orchestrator execute-tests --tag "@login" --environment "staging"

# Upload de Foto solamente
orchestrator execute-tests --tag "@uploadpic" --environment "staging"
```

---

### **Ejecutar Tests SIN Radiología**

```bash
orchestrator execute-tests \
  --tag "@priority-01 or @priority-02 or @priority-03 or @priority-04" \
  --environment "staging"
```

---

### **Ejecutar Tests CON Reportes Detallados**

```bash
orchestrator execute-tests \
  --tag "@login" \
  --environment "staging" \
  --report "html" \
  --screenshot "all"
```

---

### **Ejecutar Tests EN PARALELO (Rápido)**

```bash
orchestrator execute-tests \
  --tag "@smoke" \
  --environment "staging" \
  --parallel "true" \
  --threads "4"
```

---

### **Ejecutar Tests CON DEBUG**

```bash
orchestrator execute-tests \
  --tag "@login" \
  --environment "staging" \
  --debug "true" \
  --log-level "DEBUG"
```

---

## 🔄 CICLO DE PRUEBAS COMPLETO (PASO A PASO)

```bash
# Paso 1: Verificar Login
orchestrator execute-tests --tag "@priority-01" --environment "staging"
# Esperar resultado ✅ o ❌

# Paso 2: Si Login ✅ → Ejecutar Upload Foto
orchestrator execute-tests --tag "@priority-02" --environment "staging"

# Paso 3: Si Upload ✅ → Ejecutar Cancelar Foto
orchestrator execute-tests --tag "@priority-03" --environment "staging"

# Paso 4: Si Cancelar ✅ → Ejecutar Eliminar Foto
orchestrator execute-tests --tag "@priority-04" --environment "staging"

# Paso 5: Si Eliminar ✅ → Ejecutar Radiología
orchestrator execute-tests --tag "@priority-05" --environment "staging"

# Paso 6: Si Radiología ✅ → Ejecutar Tomografía
orchestrator execute-tests --tag "@priority-06" --environment "staging"

# Paso 7: Si Tomografía ✅ → Ejecutar Ultrasonido
orchestrator execute-tests --tag "@priority-07" --environment "staging"

# ✅ Suite Completa Exitosa!
```

---

## 📋 ALIAS DE COMANDOS (Para Configurar en tu Terminal)

Agregar esto a tu `.bashrc` o `.zshrc`:

```bash
# Comandos individuales
alias orch-login='orchestrator execute-tests --tag "@login" --environment "staging"'
alias orch-upload='orchestrator execute-tests --tag "@uploadpic" --environment "staging"'
alias orch-cancel='orchestrator execute-tests --tag "@cancelpic" --environment "staging"'
alias orch-delete='orchestrator execute-tests --tag "@deletepic" --environment "staging"'
alias orch-radio='orchestrator execute-tests --tag "@radiologia" --environment "staging"'
alias orch-tomo='orchestrator execute-tests --tag "@tomografia" --environment "staging"'
alias orch-ultra='orchestrator execute-tests --tag "@ultrasound" --environment "staging"'

# Comandos de grupo
alias orch-smoke='orchestrator execute-tests --tag "@smoke" --environment "staging"'
alias orch-photos='orchestrator execute-tests --tag "@profile-management" --environment "staging"'
alias orch-diag='orchestrator execute-tests --tag "@diagnostics" --environment "staging"'
alias orch-full='orchestrator execute-tests --tag "@suite-complete" --environment "staging"'
```

**Uso:**
```bash
orch-login    # Ejecuta solo Login
orch-smoke    # Ejecuta Smoke Tests
orch-full     # Ejecuta Suite Completa
```

---

## 🛑 SI ALGO FALLA

### **Si Login Falla ❌**

```bash
# Ejecutar con debug
orchestrator execute-tests \
  --tag "@login" \
  --environment "staging" \
  --debug "true"

# O revisar logs
cat logs/test-execution.log
```

---

### **Si Upload Falla ❌**

```bash
# Primero verificar que Login pasó
orchestrator execute-tests --tag "@login"

# Luego ejecutar Upload con screenshot
orchestrator execute-tests \
  --tag "@uploadpic" \
  --screenshot "all"
```

---

### **Si Radiología Falla ❌**

```bash
# Ejecutar solo radiología con log detallado
orchestrator execute-tests \
  --tag "@radiologia" \
  --log-level "DEBUG" \
  --screenshot "on-failure"
```

---

## 📊 MATRIZ DE REFERENCIA RÁPIDA

| **Etapa** | **Tag** | **Comando** | **Duración** |
|-----------|---------|-----------|------------|
| 1 - Login | `@priority-01` | `orchestrator execute-tests --tag "@priority-01"` | 2-3 min |
| 2 - Upload | `@priority-02` | `orchestrator execute-tests --tag "@priority-02"` | 2-3 min |
| 3 - Cancel | `@priority-03` | `orchestrator execute-tests --tag "@priority-03"` | 2-3 min |
| 4 - Delete | `@priority-04` | `orchestrator execute-tests --tag "@priority-04"` | 2-3 min |
| 5 - Radiología | `@priority-05` | `orchestrator execute-tests --tag "@priority-05"` | 5-7 min |
| 6 - Tomografía | `@priority-06` | `orchestrator execute-tests --tag "@priority-06"` | 5-7 min |
| 7 - Ultrasonido | `@priority-07` | `orchestrator execute-tests --tag "@priority-07"` | 5-7 min |
| **TOTAL** | `@suite-complete` | `orchestrator execute-tests --tag "@suite-complete"` | **25-35 min** |

---

## ✅ CHECKLIST DIARIO

```
□ Ejecutar Login (@login)
□ Ejecutar Upload (@uploadpic) 
□ Ejecutar Cancel (@cancelpic)
□ Ejecutar Delete (@deletepic)
□ Ejecutar Radiología (@radiologia)
□ Ejecutar Tomografía (@tomografia)
□ Ejecutar Ultrasonido (@ultrasound)
□ Revisar reporte HTML
□ Documentar resultados
```

---

**Última actualización:** 2026-07-31  
**Versión:** 1.0

