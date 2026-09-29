```java
// Write the class file bytes into a jar file.
var manifest = new Manifest();
manifest.getMainAttributes().put(MANIFEST_VERSION, "1.0");
manifest.getMainAttributes().put(MAIN_CLASS, "BF");
try (var os = new JarOutputStream(new BufferedOutputStream(new FileOutputStream(output)), manifest)) {
  os.putNextEntry(new JarEntry("BF.class"));
  os.write(bytes);
os.closeEntry();
}
```
