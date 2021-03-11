#!/system/bin/sh

# If there is not a persist value, we need to set one
if [[ `getprop persist.xiaomiparts.gpu_profile` == "" ]]; then
    setprop persist.xiaomiparts.gpu_profile 0
fi
