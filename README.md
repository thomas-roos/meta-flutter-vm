# meta-flutter-vm

## Virutal Machine Layer

Collection of Virtual Machine recipes

### crosvm

Builds binary `crosvm`

### crosvm-direct

Builds binary `crosvm-direct`

### crosvm-plugin

Builds shared module `libcrosvm_plugin.so`

### sommelier

Builds binary sommelier

### firecracker

Requires the following flags in your local.conf

```
TCLIBC = "musl"
RUST_PANIC_STRATEGY = "abort"
```

### jailer

Requires the following flag in your local.conf

```
RUST_PANIC_STRATEGY = "abort"
```

### seccompiler-native

Requires the following flag in your local.conf

```
RUST_PANIC_STRATEGY = "abort"
```
