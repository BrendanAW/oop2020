package wsb.devices;

import wsb.App;
import wsb.creatures.Human;

import java.util.*;

public class Phone extends Device {
    final Double screenSize;
    public List<App> applications;
    private final OS os;

    public Phone(String producer, String model, Double screenSize, OS os) {
        super(producer, model);
        this.screenSize = screenSize;
        this.os = os;
        applications = new LinkedList<>();
    }

    @Override
    public void turnOn() {
        if (os.equals(OS.IOS))
            System.out.println("Bring bling, I'm on and gonna be worthless in a week lol");
        else if (os.equals(OS.WINDOWS_MOBIE))
            System.out.println("Lol I'm a dinosaur");
        else
            System.out.println("Actually Android is better than ios in every single way, like watch me put widgets on my home screen" +
                    " like yeah I know you can do it too now but Android has been able to do that forever oh my god get " +
                    "with the times");
    }

    public void sell() {
        System.out.println("already sold");
    }

    public void installAnApp(App app, Human owner) throws Exception {
        if (app.getPrice() > 0) {
            if (owner.cash < app.getPrice()) {
                throw new Exception("not enough money");
            }
            owner.cash -= app.getPrice();
        }
        applications.add(app);
        System.out.println("Application " + app.getName() + " installed");
    }

    public void installAnApp(String name) {
        installAnApp(name, 0.0);
    }

    public void installAnApp(String... apps) {
        for (String app : apps) {
            installAnApp(app);
        }
    }

    public void installAnApp(String name, Double version) {
        System.out.println("The app " + name + " was installed in version " + version);
    }

    public boolean isInstalled(App app) {
        return applications.contains(app);
    }

    public boolean isInstalled(String appName) {
        for (App application : applications) {
            if (application.getName().equals(appName)) {
                return true;
            }
        }
        return false;
    }

}
