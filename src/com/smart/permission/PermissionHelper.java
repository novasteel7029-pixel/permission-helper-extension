package com.smart.permission;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.core.content.ContextCompat;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.runtime.*;

@DesignerComponent(
        version = 2,
        description = "Smart Bluetooth Permission Checker (Real-Time)",
        category = ComponentCategory.EXTENSION,
        nonVisible = true,
        iconName = ""
)
@SimpleObject(external = true)
public class PermissionHelper extends AndroidNonvisibleComponent {

    private Context context;

    public PermissionHelper(ComponentContainer container) {
        super(container.$form());
        this.context = container.$context();
    }

    // 🔥 Main function (your required block)
    @SimpleFunction(description = "Return true if Bluetooth permissions are granted")
    public boolean CheckBluetoothPermissions() {

        boolean scan = ContextCompat.checkSelfPermission(
                context,
                "android.permission.BLUETOOTH_SCAN"
        ) == PackageManager.PERMISSION_GRANTED;

        boolean connect = ContextCompat.checkSelfPermission(
                context,
                "android.permission.BLUETOOTH_CONNECT"
        ) == PackageManager.PERMISSION_GRANTED;

        return scan && connect;
    }

    // 🔥 Extra (optional debug)
    @SimpleFunction(description = "Check only SCAN permission")
    public boolean HasScanPermission() {
        return ContextCompat.checkSelfPermission(
                context,
                "android.permission.BLUETOOTH_SCAN"
        ) == PackageManager.PERMISSION_GRANTED;
    }

    @SimpleFunction(description = "Check only CONNECT permission")
    public boolean HasConnectPermission() {
        return ContextCompat.checkSelfPermission(
                context,
                "android.permission.BLUETOOTH_CONNECT"
        ) == PackageManager.PERMISSION_GRANTED;
    }
}
