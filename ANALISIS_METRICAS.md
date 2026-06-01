# 📊 ANÁLISIS E INTERPRETACIÓN DE MÉTRICAS DE CALIDAD
## Proyecto: Integración Continua - Calculadora y Persona
**Fecha:** 1 de junio de 2026

---

## 1. 📈 REPORTE JACOCO - COBERTURA DE CÓDIGO

### Resumen General:
- **Instrucciones cubiertas:** 63 / 183 = **34.4%** ❌ (Bajo)
- **Líneas cubiertas:** 19 / 49 = **38.8%** ❌ (Bajo)
- **Métodos cubiertos:** 8 / 18 = **44.4%** ❌ (Bajo)
- **Complejidad:** 9 / 31 = **29.0%** ❌ (Muy bajo)

### Análisis por clase:

#### **Clase: Calculadora.java**
- **Cobertura de líneas:** 11/25 = **44%**
- **Métodos sin cobertura (4):**
  1. `multiplicar()` - NO PROBADO (línea 23)
  2. `dividir()` - NO PROBADO (línea 32)
  3. `esMayorQue()` - NO PROBADO (línea 48)
  4. `resetearOperaciones()` - NO PROBADO (línea 54)

- **Métodos con cobertura (4):**
  1. `<init>()` - ✅ COMPLETO (100%)
  2. `sumar()` - ✅ COMPLETO (100%)
  3. `restar()` - ✅ COMPLETO (100%)
  4. `obtenerOperacionesRealizadas()` - ✅ COMPLETO (100%)

#### **Clase: Persona.java**
- **Cobertura de líneas:** 8/24 = **33%** (Muy baja)
- **Métodos sin cobertura (6):**
  1. `setNombre()` - NO PROBADO (línea 21) - 16 instrucciones sin ejecutar
  2. `setEdad()` - NO PROBADO (línea 31) - 9 instrucciones sin ejecutar
  3. `getEmail()` - NO PROBADO (línea 37) - 3 instrucciones sin ejecutar
  4. `setEmail()` - NO PROBADO (línea 41) - 4 instrucciones sin ejecutar
  5. `tieneEmailValido()` - NO PROBADO (línea 51) - 27 instrucciones sin ejecutar
  6. `imprimeInformacion()` - NO PROBADO (línea 60) - 10 instrucciones sin ejecutar

- **Métodos con cobertura (4):**
  1. `<init>()` - ✅ COMPLETO (100%)
  2. `getNombre()` - ✅ COMPLETO (100%)
  3. `getEdad()` - ✅ COMPLETO (100%)
  4. `esAdulto()` - ✅ COMPLETO (100%)

### ⚠️ Problemas Identificados:
- **Los setters no están siendo probados** - Esto es un riesgo porque los validadores dentro de ellos nunca se ejecutan
- **El método `tieneEmailValido()` tiene 27 instrucciones sin ejecutar** - Es crítico probar la validación de emails
- **El método `esMayorQue()` tiene lógica defectuosa** no probada y potencialmente buggy
- **Más del 60% del código NO está siendo probado** - Muy por debajo del estándar de 80%

### ✅ Recomendaciones de Mejora:
1. Agregar tests para `multiplicar()` en Calculadora
2. Agregar tests para `dividir()` y casos de error (división por cero)
3. Agregar tests para todos los setters en Persona
4. Agregar tests para validación de emails en `tieneEmailValido()`
5. Crear tests con datos inválidos para probar las validaciones

---

## 2. 🔍 REPORTE PMD - ANÁLISIS ESTÁTICO

### Resumen:
- **Total de violaciones encontradas:** 5
- **Severidad:** Priority 3 (Baja prioridad pero evitable)

### Violaciones Encontradas:

#### **Archivo: Calculadora.java**

| Línea | Tipo | Problema | Severidad |
|-------|------|----------|-----------|
| 3 | UnusedPrivateField | Campo privado `nombre` nunca utilizado | 3 |
| 6 | UnusedPrivateField | Campo privado `codigoLicencia` nunca utilizado | 3 |
| 35-36 | EmptyCatchBlock | Bloque catch vacío sin manejo de excepción | 3 |

**Análisis:**
- Línea 3: `private String nombre = "Calculadora v1.0";` - ¿Por qué existe si no se usa?
- Línea 6: `private String codigoLicencia = "LIC-12345";` - Campo de licencia no se utiliza en ningún método
- Línea 35-36: El catch de `ArithmeticException` está vacío: `catch (ArithmeticException e) { }`
  ```java
  try {
      if (b == 0) {
          throw new ArithmeticException("No se puede dividir por cero");
      }
  } catch (ArithmeticException e) {  // ← AQUÍ EL CATCH VACÍO
  }
  ```

#### **Archivo: Persona.java**

| Línea | Tipo | Problema | Severidad |
|-------|------|----------|-----------|
| 7 | UnusedPrivateField | Campo privado `telefonoEmergencia` nunca utilizado | 3 |
| 54-55 | EmptyCatchBlock | Bloque catch vacío sin manejo de excepción | 3 |

**Análisis:**
- Línea 7: `private String telefonoEmergencia;` - Declarado pero nunca inicializado ni utilizado
- Línea 54-55: Similar al caso anterior, catch vacío:
  ```java
  catch (IllegalArgumentException e) {  // ← AQUÍ EL CATCH VACÍO
  }
  ```

### 🚨 Riesgos:
- **Campos no utilizados** pueden indicar código muerto o funcionalidad incompleta
- **Bloques catch vacíos** son un **anti-patrón grave**: los errores se silencian y nunca se reportan
- Dificulta el debugging ya que las excepciones no dejan rastro

### ✅ Recomendaciones de Corrección:
1. **Opción A:** Eliminar campos no utilizados (más limpio)
2. **Opción B:** Utilizarlos en métodos de la clase
3. **Para los catch vacíos:** Loguear el error, lanzar una excepción personalizada o manejar apropiadamente

---

## 3. 🎯 REPORTE CHECKSTYLE - ESTILO DE CÓDIGO

### Resumen:
- **Total de violaciones de estilo:** 45+
- **Tipo dominante:** Problemas de indentación (sangría incorrecta)
- **Severidad:** Warnings

### Principales Problemas:

#### **1. Indentación Incorrecta** (40+ warnings)
```
Línea 1: 'member def modifier' en nivel de sangrado 4, se esperaba nivel 2
Línea 4: 'member def modifier' en nivel de sangrado 4, se esperaba nivel 2
Línea 23: 'method def' en nivel de sangrado 4, se esperaba nivel 2
...
```

**Problema:** El código usa 4 espacios para identación, pero Google Checkstyle espera 2 espacios.

#### **2. Línea muy larga** (1 warning)
```
Línea 25: La línea es mayor de 100 caracteres (encontrado 101)
```
Código problemático:
```java
System.out.println("Realizando multiplicación de " + a + " por " + b + " en la calculadora");
// Esta línea excede 100 caracteres
```

#### **3. Falta de Javadoc** (5 warnings)
```
Línea 1: Falta el comentario Javadoc (clase Calculadora)
Línea 11: Falta el comentario Javadoc (método sumar)
Línea 22: Falta el comentario Javadoc (método multiplicar)
...
```

#### **4. Bloque catch vacío** (1 warning)
```
Línea 35: Bloque catch vacío.
```

### ✅ Recomendaciones de Corrección:

1. **Cambiar indentación a 2 espacios:**
   ```java
   public class Calculadora {
     private String nombre;  // 2 espacios
     
     public Calculadora() {  // 2 espacios
     }
   ```

2. **Acortar línea larga (dividirla):**
   ```java
   // ❌ Mal: 101 caracteres
   System.out.println("Realizando multiplicación de " + a + " por " + b + " en la calculadora");
   
   // ✅ Bien: < 100 caracteres
   System.out.println("Multiplicando " + a + " por " + b);
   ```

3. **Agregar Javadoc:**
   ```java
   /**
    * Suma dos números enteros.
    * @param a primer número
    * @param b segundo número
    * @return la suma de a + b
    */
   public int sumar(int a, int b) {
     // ...
   }
   ```

---

## 4. 📋 RESUMEN EJECUTIVO

| Métrica | Estado | Valor | Meta |
|---------|--------|-------|------|
| **JaCoCo - Líneas** | ❌ MALO | 38.8% | >80% |
| **JaCoCo - Métodos** | ❌ MALO | 44.4% | >90% |
| **PMD - Violaciones** | ⚠️ ADVERTENCIA | 5 | 0 |
| **Checkstyle - Warnings** | ⚠️ ADVERTENCIA | 45+ | 0 |

### 🎯 Prioridades de Corrección:
1. **CRÍTICO:** Aumentar cobertura de código (agregar tests faltantes)
2. **ALTO:** Eliminar bloques catch vacíos y variables no utilizadas
3. **MEDIO:** Corregir indentación a 2 espacios
4. **BAJO:** Agregar documentación Javadoc

---

## 5. 📈 Plan de Acción

### Fase 1: Correcciones Inmediatas (Alta Prioridad)
- [ ] Agregar tests para métodos sin cobertura en Calculadora
- [ ] Agregar tests para todos los setters en Persona
- [ ] Eliminar variables no utilizadas
- [ ] Implementar manejadores en bloques catch

### Fase 2: Mejoras de Estilo (Media Prioridad)
- [ ] Cambiar indentación a 2 espacios en ambas clases
- [ ] Dividir línea larga en Calculadora
- [ ] Agregar comentarios Javadoc básicos

### Fase 3: Validación (Baja Prioridad)
- [ ] Re-ejecutar `mvn verify`
- [ ] Validar que nuevas métricas mejoren
- [ ] Comprometer cambios al repositorio
- [ ] Ejecutar pipeline en GitHub Actions
