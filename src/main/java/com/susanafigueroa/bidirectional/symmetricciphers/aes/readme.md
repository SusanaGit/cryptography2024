# AES

- **Bloque de Cifrado**:
  - 16bytes (16x8=128bites)

- **Keys**: Fuerza criptográfica
  - 128bits (128/8=16bytes) -> nivel básico de seguridad
  - 192bits (192/8=24bytes) -> nivel intermedio de seguridad
  - 256bits (256/8=32bytes) -> nivel alto de seguridad

## MODOS DE OPERACIÓN SOPORTADOS POR EL ALGORITMO DE CIFRADO AES
- **Para aplicaciones genéricas**:
  - CBC
  - GCM
  
- **Para datos de flujo o tiempo real**:
  - CTR
  - CFB
  - OFB
    
- **Para sistemas de archivos o discos**:
  - XTS

- **Evitar ECB por la vulnerabilidad ante análisis de patrones**

![img.png](img.png)