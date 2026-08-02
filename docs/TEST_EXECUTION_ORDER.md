# 📋 GUÍA DE ORDEN DE EJECUCIÓN DE TESTS

## 🎯 Estrategia de Tags y Ejecución Ordenada

Este documento define cómo ejecutar los tests en un **orden específico** usando **tags de prioridad** en Cucumber/Maven.

---

## 📌 ORDEN DE EJECUCIÓN RECOMENDADO

### ✅ Secuencia Obligatoria:

```
1️⃣  LOGIN (@login)                    ← Base: debe funcionar primero
2️⃣  UPLOAD PICTURE (@uploadpic)       ← Requiere estar logeado
3️⃣  CANCEL PICTURE (@cancelpic)       ← Requiere estar logeado
4️⃣  DELETE PICTURE (@deletepic)       ← Requiere estar logeado
5️⃣  RADIOLOGÍA (@radiologia)          ← Require estar logeado + acceso módulo
6️⃣  TOMOGRAFÍA (@tomografia)          ← Requiere estar logeado + acceso módulo
7️⃣  ULTRASONIDO (@ultrasound)         ← Requiere estar logeado + acceso módulo
```

**Razón:** Los tests de radiología dependen de que el login funcione primero.

---

## 🏷️ ESTRUCTURA DE TAGS RECOMENDADA

### **1. Tags de Prioridad** (Orden de Ejecución)

```gherkin
@priority-01       # Login (base)
@priority-02       # Upload Picture
@priority-03       # Cancel Picture  
@priority-04       # Delete Picture
@priority-05       # Radiología
@priority-06       # Tomografía
@priority-07       # Ultrasonido
```

### **2. Tags de Categoría** (Agrupación Funcional)

```gherkin
@authentication    # Login
@profile-management # Upload, Cancel, Delete
@diagnostics       # Radiología, Tomografía, Ultrasonido
```

### **3. Tags de Criticidad**

```gherkin
@critical          # Bloqueadores (login debe pasar)
@high              # Importante (fotos de perfil)
@medium            # Módulos específicos (diagnósticos)
```

### **4. Tags de Ambiente**

```gherkin
@smoke             # Tests rápidos (todos menos radiología)
@staging           # Ambiente específico
@production        # Producción (tests seguros)
```

---

## 📝 ACTUALIZACIÓN DE FEATURES

### **loginSucces.feature**

```gherkin
@smoke
@login
@priority-01
@authentication
@critical
Feature: FE-REQ-AUT-001 : Login Exitoso
  Como usuario de la aplicacion
  Quiero autenticarme en el sistema
  Para validar el acceso al home principal
  que se valide etiquetas del usuario activo

  Scenario Outline: Login usuario valido
    Given que el usuario esta en la pagina de login
    When ingresa credenciales validas con usuario "<username>" y password "<password>"
    Then validar nombre del usuario activo "<userActive>"

    Examples:
      | username                   | password    | userActive
      | ${BASE_USER_USER} | ${BASE_USER_PASSWORD} | ${EXPECTED_ACTIVE_USER}
```

---

### **uploadPicture.feature**

```gherkin
@smoke
@uploadpic
@priority-02
@profile-management
@high
Feature: FE-REQ-AUT-002 : Login de Usuario y Subir nueva Foto
  Como usuario de la aplicacion
  Quiero autenticarme en el sistema
  Para validar el acceso al home principal
  que se validar que se haya cargado correctamente la foto de perfil del usuario

  Scenario Outline: Login exitoso con usuario valido y agregar foto
    Given que el usuario esta en la pagina de login
    When ingresa credenciales validas con usuario "<username>" y password "<password>"
    Then da click a agregar foto
    Then cargar foto "<pathPhoto>"
    Then ajustar imagen
    Then guardar foto
    Then validar que la foto se cargo correctamente

    Examples:
      | username                   | password    | pathPhoto                              |
      | ${BASE_USER_USER} | ${BASE_USER_PASSWORD} | evidences/photos/testPicture.png       |
      | ${BASE_USER_USER} | ${BASE_USER_PASSWORD} | evidences/photos/testPictureUpdate.jpg |
      | ${BASE_USER_USER} | ${BASE_USER_PASSWORD} | evidences/photos/testFail.pdf          |
      | ${BASE_USER_USER} | ${BASE_USER_PASSWORD} | evidences/photos/testMax.jpg           |
```

---

### **cancelPicture.feature**

```gherkin
@smoke
@cancelpic
@priority-03
@profile-management
@high
Feature: FE-REQ-AUT-003 : Login de Usuario y Cancelar Foto
  Como usuario de la aplicacion
  Quiero autenticarme en el sistema
  Para validar el acceso al home principal
  que se validar que se haya cancelado correctamente la foto de perfil del usuario

  Scenario Outline: Login exitoso con usuario valido y cancelar foto
    Given que el usuario esta en la pagina de login
    When ingresa credenciales validas con usuario "<username>" y password "<password>"
    Then da click a agregar foto
    Then cargar foto "<pathPhoto>"
    Then cancelar la carga foto

    Examples:
      | username                   | password    | pathPhoto                              |
      | ${BASE_USER_USER} | ${BASE_USER_PASSWORD} | evidences/photos/testPicture.png       |
```

---

### **deletePicture.feature**

```gherkin
@smoke
@deletepic
@priority-04
@profile-management
@high
Feature: FE-REQ-AUT-004 : Login de Usuario y Eliminar Foto
  Como usuario de la aplicacion
  Quiero autenticarme en el sistema
  Para validar el acceso al home principal
  que se validar que se haya eliminado correctamente la foto de perfil del usuario

  Scenario Outline: Login exitoso con usuario valido y eliminar foto
    Given que el usuario esta en la pagina de login
    When ingresa credenciales validas con usuario "<username>" y password "<password>"
    Then da click a agregar foto
    Then cargar foto "<pathPhoto>"
    Then eliminar la foto

    Examples:
      | username                   | password    | pathPhoto                              |
      | ${BASE_USER_USER} | ${BASE_USER_PASSWORD} | evidences/photos/testPicture.png       |
```

---

### **promotionsCouponsRadiología.feature**

```gherkin
@radiologia
@priority-05
@diagnostics
@medium
Feature: FE-REQ-RAD-001 : Consulta de Radiología
  Como usuario de la aplicacion
  Quiero acceder a los servicios de radiología
  Para validar la disponibilidad de estudios radiológicos

  Scenario: Consultar disponibilidad de radiología
    Given que el usuario esta autenticado en el sistema
    When accede al módulo de radiología
    Then visualiza lista de estudios disponibles
```

---

### **promotionsCouponsTomografía.feature**

```gherkin
@tomografia
@priority-06
@diagnostics
@medium
Feature: FE-REQ-TOM-001 : Consulta de Tomografía
  Como usuario de la aplicacion
  Quiero acceder a los servicios de tomografía
  Para validar la disponibilidad de estudios tomográficos

  Scenario: Consultar disponibilidad de tomografía
    Given que el usuario esta autenticado en el sistema
    When accede al módulo de tomografía
    Then visualiza lista de estudios disponibles
```

---

### **promotionsCouponsUltrasonidos.feature**

```gherkin
@ultrasound
@priority-07
@diagnostics
@medium
Feature: FE-REQ-ULT-001 : Consulta de Ultrasonidos
  Como usuario de la aplicacion
  Quiero acceder a los servicios de ultrasonido
  Para validar la disponibilidad de estudios ultrasónicos

  Scenario: Consultar disponibilidad de ultrasonidos
    Given que el usuario esta autenticado en el sistema
    When accede al módulo de ultrasonidos
    Then visualiza lista de estudios disponibles
```

---

## 🚀 COMANDOS DE EJECUCIÓN

### **1. Ejecutar Toda la Suite en ORDEN (con Priority)**

```bash
# Ejecutar todos los tests en orden de prioridad
orchestrator execute-tests \
  --tag "@priority-01 or @priority-02 or @priority-03 or @priority-04 or @priority-05 or @priority-06 or @priority-07" \
  --environment "staging" \
  --browser "chrome"
```

**Alias Simplificado:**
```bash
orchestrator execute-tests --tag "@suite-complete" --environment "staging"
```

---

### **2. Ejecutar SOLO Autenticación y Fotos (Priority 1-4)**

```bash
orchestrator execute-tests \
  --tag "@priority-01 or @priority-02 or @priority-03 or @priority-04" \
  --environment "staging"
```

**Comando Simplificado:**
```bash
orchestrator execute-tests --tag "@smoke" --environment "staging"
```

---

### **3. Ejecutar SOLO Diagnósticos (Priority 5-7)**

```bash
orchestrator execute-tests \
  --tag "@diagnostics" \
  --environment "staging"
```

---

### **4. Ejecutar Tests CRÍTICOS SOLO (Login)**

```bash
orchestrator execute-tests \
  --tag "@critical and @authentication" \
  --environment "staging"
```

**O simplemente:**
```bash
orchestrator execute-tests --tag "@login" --environment "staging"
```

---

### **5. Ejecutar por Categoría**

```bash
# Solo autenticación y gestión de perfil
orchestrator execute-tests --tag "@authentication or @profile-management" --environment "staging"

# Solo diagnósticos
orchestrator execute-tests --tag "@diagnostics" --environment "staging"
```

---

## 📊 MATRIZ DE EJECUCIÓN RECOMENDADA

| **Fase** | **Tags** | **Cuando Ejecutar** | **Comando Rápido** |
|----------|----------|---------------------|-------------------|
| **Verificación Base** | `@login` | Siempre primero | `orchestrator execute-tests --tag "@login"` |
| **Smoke Testing** | `@smoke` | Antes de deploy | `orchestrator execute-tests --tag "@smoke"` |
| **Suite Completa** | `@priority-01...07` | Deploy final | `orchestrator execute-tests --tag "@suite-complete"` |
| **Autenticación** | `@authentication` | Cambios en seguridad | `orchestrator execute-tests --tag "@authentication"` |
| **Diagnósticos** | `@diagnostics` | Cambios en módulos | `orchestrator execute-tests --tag "@diagnostics"` |
| **Tests Críticos** | `@critical` | Gate para producción | `orchestrator execute-tests --tag "@critical"` |

---

## 🔧 CONFIGURACIÓN EN POM.XML

Agregar en `pom.xml` del proyecto:

```xml
<properties>
  <!-- Cucumber properties -->
  <cucumber.execution.dry.run>false</cucumber.execution.dry.run>
  <cucumber.publish.quiet>true</cucumber.publish.quiet>
</properties>

<plugin>
  <groupId>io.cucumber</groupId>
  <artifactId>cucumber-maven-plugin</artifactId>
  <version>7.0.0</version>
  <executions>
    <execution>
      <phase>integration-test</phase>
      <goals>
        <goal>test</goal>
      </goals>
      <configuration>
        <!-- Ejecutar en orden de prioridad -->
        <tags>@priority-01 or @priority-02 or @priority-03 or @priority-04 or @priority-05 or @priority-06 or @priority-07</tags>
        <generateReport>true</generateReport>
        <reportDirectory>target/cucumber-reports</reportDirectory>
      </configuration>
    </execution>
  </executions>
</plugin>
```

---

## 📌 RESUMEN RÁPIDO

```
┌─────────────────────────────────────────────────────────────────┐
│ TAGS DE PRIORIDAD (Ejecución en Orden)                          │
├─────────────────────────────────────────────────────────────────┤
│ @priority-01  → @login          (Base)                          │
│ @priority-02  → @uploadpic      (Requiere login)                │
│ @priority-03  → @cancelpic      (Requiere login)                │
│ @priority-04  → @deletepic      (Requiere login)                │
│ @priority-05  → @radiologia     (Módulo)                        │
│ @priority-06  → @tomografia     (Módulo)                        │
│ @priority-07  → @ultrasound     (Módulo)                        │
└─────────────────────────────────────────────────────────────────┘

COMANDOS MÁS USADOS:
→ orchestrator execute-tests --tag "@login" --environment "staging"
→ orchestrator execute-tests --tag "@smoke" --environment "staging"
→ orchestrator execute-tests --tag "@suite-complete" --environment "staging"
```

---

## ✅ PRÓXIMOS PASOS

1. **Actualizar tus .feature files** con los tags recomendados
2. **Crear alias en tu runner** para facilitar ejecución
3. **Ejecutar prueba:** `orchestrator execute-tests --tag "@login"`
4. **Validar orden:** Revisar logs de ejecución

---

**Última actualización:** 2026-07-31  
**Versión:** 1.0
