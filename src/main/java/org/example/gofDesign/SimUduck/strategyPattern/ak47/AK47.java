package org.example.gofDesign.SimUduck.strategyPattern.ak47;

import org.example.gofDesign.SimUduck.strategyPattern.ak47.magazine.MagazineStrategy;
import org.example.gofDesign.SimUduck.strategyPattern.ak47.magazine.StandardMagazine;
import org.example.gofDesign.SimUduck.strategyPattern.ak47.scope.IronSight;
import org.example.gofDesign.SimUduck.strategyPattern.ak47.scope.RedDotSight;
import org.example.gofDesign.SimUduck.strategyPattern.ak47.scope.ScopeStrategy;

public class AK47 {

    MagazineStrategy magazineStrategy;
    ScopeStrategy scopeStrategy;

    public AK47(MagazineStrategy magazineStrategy, ScopeStrategy scopeStrategy) {
        this.magazineStrategy = magazineStrategy;
        this.scopeStrategy = scopeStrategy;
    }

    public void loadMagazine() {
        magazineStrategy.load();
    }

    public void aim() {
        scopeStrategy.aim();
    }

    public void shoot() {
        System.out.println("Shooting the AK47!");
    }
}
