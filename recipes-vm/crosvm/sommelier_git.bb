#
# Copyright (c) 2021-2023 Joel Winarske
#

SUMMARY = "Nested Wayland compositor with support for X11 forwarding"
DESCRIPTION = "Sommelier is an implementation of a Wayland compositor \
               that delegates compositing to a ‘host’ compositor. Sommelier \
               includes a set of features that allows it to run inside a tight \
               jail or virtual machine."
HOMEPAGE = "https://chromium.googlesource.com/chromiumos/platform2/+/HEAD/vm_tools/sommelier/README.md"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://../../LICENSE;md5=3723389cefa40c1f86f2d5c122b17d31"                      

DEPENDS += "\
    libxkbcommon \
    pixman \
    virtual/egl \
    wayland \
    wayland-native \
"

REQUIRED_DISTRO_FEATURES = "wayland opengl"

S = "${WORKDIR}/git/vm_tools/sommelier"

SRCREV = "efb7cc7993272cf70df31f1f55035a1288a5832d"

PV:append = ".efb7cc7993"

SRC_URI += "\
    git://chromium.googlesource.com/chromiumos/platform2;protocol=https;nobranch=1;branch=main \
"

inherit meson pkgconfig features_check

EXTRA_OEMESON:append = " -Dwith_tests=false"
