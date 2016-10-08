# 004_Tutorial_launch_after_boot

## Purpose
Tutorial: run my activity on boot
remark: it is not necessary to run an activity, e.g. setting up an alarm, or other receiver

2016.10.08. by Szőke Sándor
Android Studio version: 2.2 (September 15, 2016)

## Steps needed
* create application
* change the label text to whaterev you like
* set the permission in AndroidManifest.xml as follows
```
<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
```

* add the boot_completed intent in AndroidManifest.xml:
```
<receiver android:name=".BootReciever">
    <intent-filter >
        <action android:name="android.intent.action.BOOT_COMPLETED"/>
    </intent-filter>
</receiver>
```
* add the following code to a new class BootReciever:
```java
public class BootReciever extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {

        if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))
        {
            // TODO: 2016.10.08. Maybe other activiti need to be carried out than simply run your application 
            
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
```

* switch to class BootReciever
* apply ALT+ENTER to extentend includes after the following words
  * BroadcastReceiver
  * Context
  * Intent 
* exetute and reboot, your application will be started upon next boot

