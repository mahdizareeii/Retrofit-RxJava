package com.sample.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;

public class Splash extends AppCompatActivity {


    private boolean isInstall;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (installProvider())
            everyThingsIsOk();
        else
            providerInstallIfNeededAsync();
    }

    private boolean installProvider() {
        try {
            ProviderInstaller.installIfNeeded(Splash.this);
            return true;
        } catch (GooglePlayServicesRepairableException e) {
            return false;

        } catch (GooglePlayServicesNotAvailableException e) {
            return false;
        }
    }

    private void providerInstallIfNeededAsync() {
        ProviderInstaller.installIfNeededAsync(Splash.this, new ProviderInstaller.ProviderInstallListener() {
            @Override
            public void onProviderInstalled() {
                everyThingsIsOk();
            }

            @Override
            public void onProviderInstallFailed(int i, Intent intent) {
                GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
                if (googleApiAvailability.isUserResolvableError(i)) {
                    googleApiAvailability.showErrorDialogFragment(Splash.this, i, 1,
                            new DialogInterface.OnCancelListener() {
                                @Override
                                public void onCancel(DialogInterface dialog) {
                                    onProviderInstallerNotAvailable();
                                }
                            });
                } else {
                    onProviderInstallerNotAvailable();
                }
            }
        });
    }

    private void everyThingsIsOk() {
        startActivity(new Intent(Splash.this, MainActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            isInstall = true;
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (isInstall) {
            providerInstallIfNeededAsync();
        }
        isInstall = false;
    }


    private void onProviderInstallerNotAvailable() {
        // This is reached if the provider cannot be updated for some reason.
        // App should consider all HTTP communication to be vulnerable, and take
        // appropriate action.
    }

}
