# 📚 Índice de Documentación QA - Centro de Referencia

**Versión:** 1.0  
**Última actualización:** 2026-07-31  
**Estado:** ✅ Completo y listo para usar

---

## 🎯 ¿Qué necesitas?

### Si necesitas... → Lee esto:

| Tu Necesidad | Documento | Tiempo |
|---|---|---|
| **Aprender todos los comandos** | [`QA_COMMANDS_GUIDE.md`](#qa_commands_guidemd) | 20 min |
| **Referencia rápida para imprimir** | [`QA_QUICK_REFERENCE.md`](#qa_quick_referencemd) | 5 min |
| **Mapeo de frases a comandos** | [`COMMANDS_MAPPING.yml`](#commands_mappingyml) | 10 min |
| **Ver ejemplos paso a paso** | [`EXECUTION_EXAMPLES.md`](#execution_examplesmd) | 15 min |
| **Seguir un flujo completo** | Ir a sección [Flujos de Trabajo](#-flujos-de-trabajo) | Varía |
| **Resolver problema rápido** | Ir a sección [Solución de Problemas](#-solución-de-problemas) | 5 min |

---

## 📖 Documentos Principales

### QA_COMMANDS_GUIDE.md
**La guía más completa - Lee primero si es tu primera vez**

```markdown
Contiene:
✅ Tabla rápida de 14 comandos
✅ Descripción detallada de cada uno
✅ Parámetros requeridos y opcionales
✅ Ejemplos completos
✅ Casos de uso comunes
✅ Solución de problemas

Secciones:
1. Analizar Historia de Usuario
2. Desarrollar Test Scripts POM
3. Generar Plan de Pruebas
4. Diseñar Escenarios de Prueba
5. Crear Localizadores POM
6. Ejecutar Pruebas por Tag
7. Ejecutar Todas las Pruebas
8. Crear Evidencia en Jira
9. Leer Requisitos de Jira
10. Disparar Pipeline GitHub
11. Inspeccionar Elemento
12. Capturar Screenshot
13. Obtener Reporte de Pruebas
14. Generar Datos de Prueba

Mejor para: Aprender profundamente cada comando
Duración: 20-30 minutos lectura completa
```

**→ [Abrir QA_COMMANDS_GUIDE.md](QA_COMMANDS_GUIDE.md)**

---

### QA_QUICK_REFERENCE.md
**La tarjeta de referencia - Imprime y pégala en tu escritorio**

```markdown
Contiene:
✅ Comandos más usados (Copy-Paste)
✅ Tabla de parámetros comunes
✅ Flujos típicos listos (Copy-Paste)
✅ Comandos de emergencia
✅ Checklist antes de ejecutar
✅ Tips Pro

Mejor para: Acceso rápido durante el trabajo
Duración: 5 minutos
Tamaño: 1 página (imprimible)
```

**→ [Abrir QA_QUICK_REFERENCE.md](QA_QUICK_REFERENCE.md)**

---

### COMMANDS_MAPPING.yml
**Mapeo estructurado - Para integraciones y automatización**

```markdown
Contiene:
✅ 14 comandos en formato YAML
✅ Frases naturales mapeadas
✅ Parámetros estructurados
✅ Ejemplos verificados
✅ Tiempos de ejecución
✅ Información de agentes

Mejor para: Automatización, integraciones, desarrollo
Duración: 10 minutos
Formato: YAML (parseable)
```

**→ [Abrir COMMANDS_MAPPING.yml](COMMANDS_MAPPING.yml)**

---

### EXECUTION_EXAMPLES.md
**Ejemplos ejecutables paso a paso**

```markdown
Contiene:
✅ Ciclo completo de 4 días (Mon-Thu)
✅ Ejecución rápida (Smoke tests)
✅ Debug y troubleshooting
✅ Integraciones CI/CD
✅ Casos urgentes (Production)
✅ Tips de productividad

Secciones:
1. Comenzar un nuevo proyecto
2. Ciclo completo de una historia (4 días)
3. Ejecutar pruebas rápidamente
4. Debuggear problemas
5. Integraciones CI/CD
6. Casos urgentes

Mejor para: Ver cómo se ve todo en acción
Duración: 15 minutos
Formato: Bash/PowerShell (Copy-Paste Ready)
```

**→ [Abrir EXECUTION_EXAMPLES.md](EXECUTION_EXAMPLES.md)**

---

## 🔄 Flujos de Trabajo

### Flujo 1: Primera Vez (Lee esto primero)

```
1. Abre QA_COMMANDS_GUIDE.md
   ↓
2. Lee sección "Introducción"
   ↓
3. Mira la "Tabla Rápida de Comandos"
   ↓
4. Lee un ejemplo completo (Analizar Historia de Usuario)
   ↓
5. ¡Listo! Ya entiendes cómo funciona
```

**Tiempo:** 15 minutos

---

### Flujo 2: Implementar Primera Historia

```
1. Lee EXECUTION_EXAMPLES.md - Sección "Ciclo Completo de una Historia"
   ↓
2. Sigue el flujo de 4 días paso a paso
   ↓
3. Copia-pega cada comando
   ↓
4. Ajusta parámetros según tu historia
   ↓
5. ¡Listo!
```

**Tiempo:** Variable (depende del proyecto)

**Documentos necesarios:** 
- QA_COMMANDS_GUIDE.md (referencia)
- EXECUTION_EXAMPLES.md (paso a paso)

---

### Flujo 3: Ejecución Rápida (Smoke Tests)

```
1. Abre QA_QUICK_REFERENCE.md
   ↓
2. Ve a sección "Comandos Más Usados"
   ↓
3. Busca "Ejecutar pruebas por tag"
   ↓
4. Copia-pega el comando
   ↓
5. Cambia el tag (@smoke → @login, etc)
   ↓
6. Ejecuta
```

**Tiempo:** 2 minutos

**Documentos necesarios:**
- QA_QUICK_REFERENCE.md (solo esto)

---

### Flujo 4: Debuggear Problema

```
1. Abre EXECUTION_EXAMPLES.md
   ↓
2. Busca sección "Debuggear Problemas"
   ↓
3. Encuentra tu escenario
   ↓
4. Copia-pega los pasos
   ↓
5. Ejecuta
```

**Tiempo:** 5-10 minutos

**Documentos necesarios:**
- EXECUTION_EXAMPLES.md
- QA_COMMANDS_GUIDE.md (si necesitas más detalles)

---

### Flujo 5: Caso Urgente (Production Bug)

```
1. Abre QA_QUICK_REFERENCE.md
   ↓
2. Busca "Comandos de Emergencia"
   ↓
3. Copia el comando de "Bug crítico en producción"
   ↓
4. Ejecuta inmediatamente
```

**Tiempo:** 1 minuto

**Documentos necesarios:**
- QA_QUICK_REFERENCE.md (solo esto)

---

## 🎯 Guía de Comandos por Actividad

### Actividad: Analizar Requisitos

**¿Qué hacer?**
- Leer historia de usuario
- Entender criterios de aceptación
- Extraer información de Jira

**Comandos relacionados:**
```bash
orchestrator read-jira-requirements --issue "US-001"
orchestrator analyze-user-story --file "US-001.md"
```

**Documentación:**
- Ver QA_COMMANDS_GUIDE.md → Secc. 1 y 9
- Ver EXECUTION_EXAMPLES.md → Sección "Ciclo Completo" → Día 1

---

### Actividad: Diseñar Pruebas

**¿Qué hacer?**
- Crear plan de pruebas
- Diseñar escenarios BDD
- Generar datos de prueba

**Comandos relacionados:**
```bash
orchestrator generate-test-plan --story "US-001"
orchestrator design-scenarios --story "US-001" --bdd-format "gherkin"
orchestrator generate-test-data --type "user-credentials"
```

**Documentación:**
- Ver QA_COMMANDS_GUIDE.md → Secc. 3, 4, 14
- Ver EXECUTION_EXAMPLES.md → Sección "Ciclo Completo" → Día 2

---

### Actividad: Implementar Scripts

**¿Qué hacer?**
- Crear test scripts POM
- Generar localizadores automáticamente
- Validar elementos

**Comandos relacionados:**
```bash
orchestrator design-test-scripts --story "US-001"
orchestrator generate-locators --page "LoginPage"
orchestrator inspect-element --selector "button.login"
```

**Documentación:**
- Ver QA_COMMANDS_GUIDE.md → Secc. 2, 5, 11
- Ver EXECUTION_EXAMPLES.md → Sección "Ciclo Completo" → Día 3

---

### Actividad: Ejecutar Pruebas

**¿Qué hacer?**
- Ejecutar smoke tests
- Ejecutar suite completa
- Obtener reportes

**Comandos relacionados:**
```bash
orchestrator execute-tests --tag "@smoke"
orchestrator execute-all-tests --parallel "true"
orchestrator get-latest-report --format "html"
```

**Documentación:**
- Ver QA_COMMANDS_GUIDE.md → Secc. 6, 7, 13
- Ver EXECUTION_EXAMPLES.md → Sección "Ejecutar Pruebas Rápidamente"

---

### Actividad: Reportar Resultados

**¿Qué hacer?**
- Crear evidencia en Jira
- Publicar screenshots
- Compartir reporte

**Comandos relacionados:**
```bash
orchestrator create-jira-evidence --issue "QA-001" --report "results.json"
orchestrator capture-screenshot --browser "chrome" --url "https://..."
orchestrator trigger-pipeline --workflow "test-automation"
```

**Documentación:**
- Ver QA_COMMANDS_GUIDE.md → Secc. 8, 10, 12
- Ver EXECUTION_EXAMPLES.md → Sección "Ciclo Completo" → Día 4

---

## 🆘 Solución de Problemas

### Problema: No sé qué comando usar

**Solución:**
1. Abre QA_COMMANDS_GUIDE.md
2. Busca por palabra clave (Ctrl+F)
3. Lee la sección del comando
4. Copia-pega el ejemplo

**Tiempo:** 2-3 minutos

---

### Problema: El comando dice "parámetro inválido"

**Solución:**
1. Abre QA_COMMANDS_GUIDE.md
2. Ve a la sección del comando
3. Revisa "Parámetros" requeridos y opcionales
4. Verifica que todos estén correctos
5. Vuelve a ejecutar

**Tiempo:** 3-5 minutos

---

### Problema: Tests fallan y necesito debuggear

**Solución:**
1. Abre EXECUTION_EXAMPLES.md
2. Ve a "Debuggear Problemas"
3. Encuentra tu escenario
4. Sigue los pasos indicados

**Tiempo:** 5-10 minutos

---

### Problema: Necesito referencia rápida

**Solución:**
1. Abre QA_QUICK_REFERENCE.md
2. Busca tu comando
3. Copia-pega
4. Ejecuta

**Tiempo:** 1-2 minutos

---

## 📊 Estadísticas

| Métrica | Valor |
|---|---|
| Comandos documentados | 14 |
| Ejemplos paso a paso | 50+ |
| Frases naturales mapeadas | 30+ |
| Parámetros documentados | 100+ |
| Flujos de trabajo | 6 |
| Tamaño total documentación | 50+ KB |
| Tiempo lectura completa | 1-2 horas |
| Tiempo referencia rápida | 2-5 minutos |

---

## 🎓 Niveles de Comprensión

### Nivel 1️⃣ - Principiante (30 minutos)
**Qué leer:**
1. QA_QUICK_REFERENCE.md
2. EXECUTION_EXAMPLES.md (sección "Comenzar nuevo proyecto")

**Qué sabrás:**
- Cómo ejecutar comandos básicos
- Copiar-pegar ejemplos
- Flujo general de trabajo

---

### Nivel 2️⃣ - Intermedio (1-2 horas)
**Qué leer:**
1. QA_COMMANDS_GUIDE.md (completo)
2. EXECUTION_EXAMPLES.md (todas las secciones)
3. COMMANDS_MAPPING.yml

**Qué sabrás:**
- Todos los comandos disponibles
- Parámetros avanzados
- Optimizaciones y casos especiales

---

### Nivel 3️⃣ - Experto (2-3 horas)
**Qué leer:**
1. Todo lo anterior
2. Código fuente de orchestrator
3. Lógica de agentes

**Qué sabrás:**
- Integración completa
- Extensiones posibles
- Automatización avanzada

---

## 🚀 Próximos Pasos Recomendados

### Después de leer esta documentación:

1. **Lee QA_COMMANDS_GUIDE.md** (20 min)
   - Entiende todos los comandos disponibles

2. **Imprime QA_QUICK_REFERENCE.md** (5 min)
   - Pégala en tu escritorio

3. **Abre EXECUTION_EXAMPLES.md** (15 min)
   - Sigue el flujo "Ciclo Completo de una Historia"

4. **Ejecuta tu primer comando** (5 min)
   - Comienza con `orchestrator read-jira-requirements --issue "YOUR-ID"`

5. **¡Listo!** 
   - Ya eres productivo con la herramienta

---

## 📞 Centro de Ayuda

### ¿Dónde encontrar cada cosa?

| Necesidad | Ir a | Sección |
|---|---|---|
| Ver todos los comandos | QA_COMMANDS_GUIDE.md | Tabla Rápida |
| Copiar comando rápido | QA_QUICK_REFERENCE.md | Comandos Más Usados |
| Ver parámetros de comando | QA_COMMANDS_GUIDE.md | Comandos Detallados |
| Ver ejemplo completo | EXECUTION_EXAMPLES.md | Corresponde a actividad |
| Mapeo de frases | COMMANDS_MAPPING.yml | Sección commands |
| Flujo de 4 días | EXECUTION_EXAMPLES.md | Ciclo Completo |
| Caso de emergencia | QA_QUICK_REFERENCE.md | Casos Urgentes |
| Debuggear problema | EXECUTION_EXAMPLES.md | Debuggear Problemas |

---

## ✅ Checklist: Antes de Empezar

- [ ] He leído esta página (INDEX.md)
- [ ] He impreso QA_QUICK_REFERENCE.md
- [ ] He abierto QA_COMMANDS_GUIDE.md
- [ ] Tengo EXECUTION_EXAMPLES.md a mano
- [ ] Sé qué comando necesito ejecutar
- [ ] Tengo todos los parámetros listos
- [ ] Estoy listo para ejecutar

---

## 🎯 Resumen Rápido

```
Para APRENDER              → QA_COMMANDS_GUIDE.md
Para REFERENCIA RÁPIDA     → QA_QUICK_REFERENCE.md  
Para VER EJEMPLOS          → EXECUTION_EXAMPLES.md
Para MAPEO TÉCNICO         → COMMANDS_MAPPING.yml
Para ESTE ÍNDICE           → INDEX.md
```

---

**Versión:** 1.0  
**Última actualización:** 2026-07-31  
**Estado:** ✅ Completo y verificado  
**Listo para:** Producción inmediata

---

¿Listo para comenzar? → **[Abre QA_COMMANDS_GUIDE.md](QA_COMMANDS_GUIDE.md)**
