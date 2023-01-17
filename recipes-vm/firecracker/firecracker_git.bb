#
# Copyright (c) 2021-2023 Joel Winarske
#

SUMMARY = "Firecracker enables you to deploy workloads in lightweight virtual machines, \
           called microVMs, which provide enhanced security and workload isolation over \
           traditional VMs, while enabling the speed and resource efficiency of containers."
HOMEPAGE = "https://firecracker-microvm.github.io/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS += "seccompiler-native"

S = "${WORKDIR}/git"

SRCREV = "ad7163093159c3af3b08c10b048a7df8f4950af0"

PV:append = ".ad71630931"

SRC_URI += "\
    gitsm://github.com/firecracker-microvm/firecracker.git;protocol=https;nobranch=1;branch=master \
    file://0001-use-prebuilt-seccompiler.patch \
    "

inherit cargo

CARGO_SRC_DIR = "src/firecracker"

SRC_URI += " \
    crate://crates.io/aead/0.4.3 \
    crate://crates.io/aes-gcm/0.9.4 \
    crate://crates.io/aes/0.7.5 \
    crate://crates.io/atty/0.2.14 \
    crate://crates.io/autocfg/1.0.1 \
    crate://crates.io/base64/0.13.0 \
    crate://crates.io/bincode/1.3.3 \
    crate://crates.io/bindgen/0.59.2 \
    crate://crates.io/bitflags/1.3.2 \
    crate://crates.io/bstr/0.2.17 \
    crate://crates.io/bumpalo/3.9.1 \
    crate://crates.io/byteorder/1.4.3 \
    crate://crates.io/cast/0.2.7 \
    crate://crates.io/cc/1.0.73 \
    crate://crates.io/cexpr/0.6.0 \
    crate://crates.io/cfg-if/0.1.10 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/cipher/0.3.0 \
    crate://crates.io/clang-sys/1.3.1 \
    crate://crates.io/clap/2.34.0 \
    crate://crates.io/cpufeatures/0.2.5 \
    crate://crates.io/crc64/1.0.0 \
    crate://crates.io/criterion-plot/0.4.4 \
    crate://crates.io/criterion/0.3.5 \
    crate://crates.io/crossbeam-channel/0.5.4 \
    crate://crates.io/crossbeam-deque/0.8.1 \
    crate://crates.io/crossbeam-epoch/0.9.7 \
    crate://crates.io/crossbeam-utils/0.8.7 \
    crate://crates.io/csv-core/0.1.10 \
    crate://crates.io/csv/1.1.6 \
    crate://crates.io/ctr/0.8.0 \
    crate://crates.io/device_tree/1.1.0 \
    crate://crates.io/either/1.6.1 \
    crate://crates.io/event-manager/0.2.1 \
    crate://crates.io/generic-array/0.14.5 \
    crate://crates.io/getrandom/0.2.4 \
    crate://crates.io/ghash/0.4.4 \
    crate://crates.io/glob/0.3.0 \
    crate://crates.io/half/1.8.2 \
    crate://crates.io/hermit-abi/0.1.19 \
    crate://crates.io/itertools/0.10.3 \
    crate://crates.io/itoa/0.4.8 \
    crate://crates.io/itoa/1.0.1 \
    crate://crates.io/js-sys/0.3.56 \
    crate://crates.io/kvm-ioctls/0.12.0 \
    crate://crates.io/lazy_static/1.4.0 \
    crate://crates.io/lazycell/1.3.0 \
    crate://crates.io/libc/0.2.117 \
    crate://crates.io/libloading/0.7.3 \
    crate://crates.io/linux-loader/0.7.0 \
    crate://crates.io/log/0.4.14 \
    crate://crates.io/memchr/2.4.1 \
    crate://crates.io/memoffset/0.6.5 \
    crate://crates.io/minimal-lexical/0.2.1 \
    crate://crates.io/nix/0.23.1 \
    crate://crates.io/nom/7.1.0 \
    crate://crates.io/num-traits/0.2.14 \
    crate://crates.io/num_cpus/1.13.1 \
    crate://crates.io/oorandom/11.1.3 \
    crate://crates.io/opaque-debug/0.3.0 \
    crate://crates.io/peeking_take_while/0.1.2 \
    crate://crates.io/plotters-backend/0.3.2 \
    crate://crates.io/plotters-svg/0.3.1 \
    crate://crates.io/plotters/0.3.1 \
    crate://crates.io/polyval/0.5.3 \
    crate://crates.io/ppv-lite86/0.2.16 \
    crate://crates.io/proc-macro2/1.0.36 \
    crate://crates.io/proptest/1.0.0 \
    crate://crates.io/quick-error/2.0.1 \
    crate://crates.io/quote/1.0.15 \
    crate://crates.io/rand/0.8.4 \
    crate://crates.io/rand_chacha/0.3.1 \
    crate://crates.io/rand_core/0.6.3 \
    crate://crates.io/rand_xorshift/0.3.0 \
    crate://crates.io/rayon-core/1.9.1 \
    crate://crates.io/rayon/1.5.1 \
    crate://crates.io/regex-automata/0.1.10 \
    crate://crates.io/regex-syntax/0.6.25 \
    crate://crates.io/regex/1.5.5 \
    crate://crates.io/rustc-hash/1.1.0 \
    crate://crates.io/rustc_version/0.4.0 \
    crate://crates.io/ryu/1.0.9 \
    crate://crates.io/same-file/1.0.6 \
    crate://crates.io/scopeguard/1.1.0 \
    crate://crates.io/semver/1.0.5 \
    crate://crates.io/serde/1.0.136 \
    crate://crates.io/serde_cbor/0.11.2 \
    crate://crates.io/serde_derive/1.0.136 \
    crate://crates.io/serde_json/1.0.78 \
    crate://crates.io/shlex/1.1.0 \
    crate://crates.io/subtle/2.4.1 \
    crate://crates.io/syn/1.0.86 \
    crate://crates.io/textwrap/0.11.0 \
    crate://crates.io/thiserror-impl/1.0.30 \
    crate://crates.io/thiserror/1.0.30 \
    crate://crates.io/timerfd/1.2.0 \
    crate://crates.io/tinytemplate/1.2.1 \
    crate://crates.io/typenum/1.15.0 \
    crate://crates.io/unicode-width/0.1.9 \
    crate://crates.io/unicode-xid/0.2.2 \
    crate://crates.io/universal-hash/0.4.1 \
    crate://crates.io/userfaultfd-sys/0.4.1 \
    crate://crates.io/userfaultfd/0.4.2 \
    crate://crates.io/version_check/0.9.4 \
    crate://crates.io/versionize/0.1.9 \
    crate://crates.io/versionize_derive/0.1.4 \
    crate://crates.io/vm-fdt/0.1.0 \
    crate://crates.io/vm-memory/0.9.0 \
    crate://crates.io/vm-superio/0.5.0 \
    crate://crates.io/vmm-sys-util/0.11.0 \
    crate://crates.io/walkdir/2.3.2 \
    crate://crates.io/wasi/0.10.2+wasi-snapshot-preview1 \
    crate://crates.io/wasm-bindgen-backend/0.2.79 \
    crate://crates.io/wasm-bindgen-macro-support/0.2.79 \
    crate://crates.io/wasm-bindgen-macro/0.2.79 \
    crate://crates.io/wasm-bindgen-shared/0.2.79 \
    crate://crates.io/wasm-bindgen/0.2.79 \
    crate://crates.io/web-sys/0.3.56 \
    crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi-util/0.1.5 \
    crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi/0.3.9 \
    gitsm://github.com/firecracker-microvm/kvm-bindings;protocol=https;branch=master;name=kvm-bindings;destsuffix=kvm-bindings \
    gitsm://github.com/firecracker-microvm/micro-http;protocol=https;branch=main;name=micro_http;destsuffix=micro_http \
"

do_compile[network] = "1"

SRCREV_FORMAT .= "_kvm-bindings"
SRCREV_kvm-bindings = "e8359204b41d5c2e7c5af9ae5c26283b62337740"
PV_kvm-bindings = "v0.6.0-1"
EXTRA_OECARGO_PATHS += "${WORKDIR}/kvm-bindings"

SRCREV_FORMAT .= "_micro_http"
SRCREV_micro_http = "0a58eb1ece68e326e68365c4297d0a7c08ecd9bc"
EXTRA_OECARGO_PATHS += "${WORKDIR}/micro_http"

do_configure:prepend:x86_64() {
    cp ${S}/resources/seccomp/x86_64-unknown-linux-musl.json \
        ${S}/resources/seccomp/x86_64-poky-linux-musl.json
}

do_configure:prepend:aarch64() {
    cp ${S}/resources/seccomp/aarch64-unknown-linux-musl.json \
        ${S}/resources/seccomp/aarch64-poky-linux-musl.json
}
