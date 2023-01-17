#
# Copyright (c) 2021-2023 Joel Winarske
#

SUMMARY = "The ChromeOS Virtual Machine Monitor"
HOMEPAGE = "https://crosvm.dev/book/introduction.html"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1ed361f9fc790c1054d81a7ef041a34"

DEPENDS += "\
    libcap \
    protobuf-native \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland wayland-native', '', d)} \
"

S = "${WORKDIR}/git"

SRCREV = "4016e4475a0ad7b4a617acf447006f0d2cfbd7b5"

PV:append = ".4016e4475a"

SRC_URI += "\
    git://chromium.googlesource.com/crosvm/crosvm/;protocol=https;nobranch=1;branch=main \
    file://0001-Remove-rust-toolchain-lock.patch \
"

inherit cargo pkgconfig

CARGO_BUILD_FLAGS += '--features "direct" --bin crosvm-direct'

SRC_URI += " \
    crate://crates.io/aho-corasick/0.7.20 \
    crate://crates.io/android_system_properties/0.1.5 \
    crate://crates.io/ansi_term/0.12.1 \
    crate://crates.io/anyhow/1.0.68 \
    crate://crates.io/argh/0.1.10 \
    crate://crates.io/argh_derive/0.1.10 \
    crate://crates.io/argh_shared/0.1.10 \
    crate://crates.io/async-task/4.3.0 \
    crate://crates.io/async-trait/0.1.61 \
    crate://crates.io/atty/0.2.14 \
    crate://crates.io/autocfg/1.1.0 \
    crate://crates.io/bitflags/1.3.2 \
    crate://crates.io/bumpalo/3.12.0 \
    crate://crates.io/byteorder/1.4.3 \
    crate://crates.io/bytes/1.3.0 \
    crate://crates.io/cbindgen/0.20.0 \
    crate://crates.io/cc/1.0.78 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/chrono/0.4.23 \
    crate://crates.io/clap/2.34.0 \
    crate://crates.io/codespan-reporting/0.11.1 \
    crate://crates.io/const-sha1/0.2.0 \
    crate://crates.io/core-foundation-sys/0.8.3 \
    crate://crates.io/crc32fast/1.3.2 \
    crate://crates.io/crossbeam-utils/0.8.14 \
    crate://crates.io/cxx/1.0.86 \
    crate://crates.io/cxx-build/1.0.86 \
    crate://crates.io/cxxbridge-flags/1.0.86 \
    crate://crates.io/cxxbridge-macro/1.0.86 \
    crate://crates.io/dbus/0.9.7 \
    crate://crates.io/derive-into-owned/0.1.0 \
    crate://crates.io/downcast-rs/1.2.0 \
    crate://crates.io/either/1.8.0 \
    crate://crates.io/enumn/0.1.6 \
    crate://crates.io/env_logger/0.9.3 \
    crate://crates.io/fastrand/1.8.0 \
    crate://crates.io/fnv/1.0.7 \
    crate://crates.io/futures/0.3.25 \
    crate://crates.io/futures-channel/0.3.25 \
    crate://crates.io/futures-core/0.3.25 \
    crate://crates.io/futures-executor/0.3.25 \
    crate://crates.io/futures-io/0.3.25 \
    crate://crates.io/futures-macro/0.3.25 \
    crate://crates.io/futures-sink/0.3.25 \
    crate://crates.io/futures-task/0.3.25 \
    crate://crates.io/futures-util/0.3.25 \
    crate://crates.io/gdbstub/0.6.3 \
    crate://crates.io/gdbstub_arch/0.2.4 \
    crate://crates.io/getrandom/0.2.8 \
    crate://crates.io/hashbrown/0.12.3 \
    crate://crates.io/heck/0.3.3 \
    crate://crates.io/hermit-abi/0.1.19 \
    crate://crates.io/hermit-abi/0.2.6 \
    crate://crates.io/humantime/2.1.0 \
    crate://crates.io/iana-time-zone/0.1.53 \
    crate://crates.io/iana-time-zone-haiku/0.1.1 \
    crate://crates.io/indexmap/1.9.2 \
    crate://crates.io/instant/0.1.12 \
    crate://crates.io/intrusive-collections/0.9.4 \
    crate://crates.io/itoa/1.0.5 \
    crate://crates.io/js-sys/0.3.60 \
    crate://crates.io/libc/0.2.139 \
    crate://crates.io/libdbus-sys/0.2.3 \
    crate://crates.io/libslirp-sys/4.2.1 \
    crate://crates.io/libudev/0.2.0 \
    crate://crates.io/libudev-sys/0.1.4 \
    crate://crates.io/link-cplusplus/1.0.8 \
    crate://crates.io/log/0.4.17 \
    crate://crates.io/managed/0.8.0 \
    crate://crates.io/memchr/2.5.0 \
    crate://crates.io/memoffset/0.5.6 \
    crate://crates.io/memoffset/0.6.5 \
    crate://crates.io/num-integer/0.1.45 \
    crate://crates.io/num-traits/0.2.15 \
    crate://crates.io/num_cpus/1.15.0 \
    crate://crates.io/once_cell/1.17.0 \
    crate://crates.io/paste/1.0.11 \
    crate://crates.io/pcap-file/1.1.1 \
    crate://crates.io/pin-project-lite/0.2.9 \
    crate://crates.io/pin-utils/0.1.0 \
    crate://crates.io/pkg-config/0.3.26 \
    crate://crates.io/ppv-lite86/0.2.17 \
    crate://crates.io/proc-macro2/1.0.50 \
    crate://crates.io/protobuf/2.28.0 \
    crate://crates.io/protobuf-codegen/2.28.0 \
    crate://crates.io/protoc/2.28.0 \
    crate://crates.io/protoc-rust/2.28.0 \
    crate://crates.io/quote/0.3.15 \
    crate://crates.io/quote/1.0.23 \
    crate://crates.io/rand/0.8.5 \
    crate://crates.io/rand_chacha/0.3.1 \
    crate://crates.io/rand_core/0.6.4 \
    crate://crates.io/redox_syscall/0.2.16 \
    crate://crates.io/regex/1.7.1 \
    crate://crates.io/regex-syntax/0.6.28 \
    crate://crates.io/remain/0.2.6 \
    crate://crates.io/remove_dir_all/0.5.3 \
    crate://crates.io/ryu/1.0.12 \
    crate://crates.io/scratch/1.0.3 \
    crate://crates.io/scudo/0.1.3 \
    crate://crates.io/scudo-proc-macros/0.1.0 \
    crate://crates.io/scudo-sys/0.2.2 \
    crate://crates.io/serde/1.0.152 \
    crate://crates.io/serde_derive/1.0.152 \
    crate://crates.io/serde_json/1.0.91 \
    crate://crates.io/slab/0.4.7 \
    crate://crates.io/smallvec/1.10.0 \
    crate://crates.io/strsim/0.8.0 \
    crate://crates.io/syn/0.11.11 \
    crate://crates.io/syn/1.0.107 \
    crate://crates.io/synom/0.11.3 \
    crate://crates.io/tempfile/3.3.0 \
    crate://crates.io/termcolor/1.2.0 \
    crate://crates.io/terminal_size/0.1.17 \
    crate://crates.io/textwrap/0.11.0 \
    crate://crates.io/thiserror/1.0.38 \
    crate://crates.io/thiserror-impl/1.0.38 \
    crate://crates.io/time/0.1.45 \
    crate://crates.io/toml/0.5.10 \
    crate://crates.io/unicode-ident/1.0.6 \
    crate://crates.io/unicode-segmentation/1.10.0 \
    crate://crates.io/unicode-width/0.1.10 \
    crate://crates.io/unicode-xid/0.0.4 \
    crate://crates.io/uuid/0.8.2 \
    crate://crates.io/vec_map/0.8.2 \
    crate://crates.io/wasi/0.10.0+wasi-snapshot-preview1 \
    crate://crates.io/wasi/0.11.0+wasi-snapshot-preview1 \
    crate://crates.io/wasm-bindgen/0.2.83 \
    crate://crates.io/wasm-bindgen-backend/0.2.83 \
    crate://crates.io/wasm-bindgen-macro/0.2.83 \
    crate://crates.io/wasm-bindgen-macro-support/0.2.83 \
    crate://crates.io/wasm-bindgen-shared/0.2.83 \
    crate://crates.io/which/4.3.0 \
    crate://crates.io/widestring/0.5.1 \
    crate://crates.io/winapi/0.3.9 \
    crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi-util/0.1.5 \
    crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
    crate://crates.io/windows/0.10.0 \
    crate://crates.io/windows_gen/0.10.0 \
    crate://crates.io/windows_macros/0.10.0 \
    crate://crates.io/wmi/0.9.3 \
    git://chromium.googlesource.com/chromiumos/platform/minigbm;protocol=https;nobranch=1;name=minigbm;destsuffix=git/third_party/minigbm \
    git://chromium.googlesource.com/chromiumos/third_party/virglrenderer;protocol=https;nobranch=1;name=virglrenderer;destsuffix=git/third_party/virglrenderer \
    git://android.googlesource.com/platform/external/minijail;protocol=https;nobranch=1;name=minijail;destsuffix=git/third_party/minijail \
"

SRCREV_FORMAT .= "_minigbm"
SRCREV_minigbm = "ef852e007ce7663e1f8c81dedc1ec5efc7c81e30"
SRCREV_FORMAT .= "_virglrenderer"
SRCREV_virglrenderer = "4770f706db2d0e7731264cb36a659c764c7787f1"
SRCREV_FORMAT .= "_minijail"
SRCREV_minijail = "77c59db8ff9ab7795ca1e986e2658b02d9252498"
