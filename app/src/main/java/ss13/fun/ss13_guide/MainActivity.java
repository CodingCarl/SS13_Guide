package ss13.fun.ss13_guide;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String window = "000",
            spin1,
            spin2,
            spin3,
            spinsum12,
            spinsum123;
    int selector[] = {0,0,0};
    Spinner dropdown,
            dropdown1,
            dropdown2;
    TextView myjavatextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        dropdown = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.codebases, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);

        dropdown1 = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.make_a_choice, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown1.setAdapter(adapter1);

        dropdown2 = (Spinner)findViewById(R.id.spinner2);
        //String[] items2 = new String[]{"Guides", "Game Modes", "Objects"};
        //ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
        R.array.make_a_choice, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown2.setAdapter(adapter2);

        myjavatextview = (TextView)findViewById(R.id.TEXT_STATUS_ID);
        //I used this so I can access the main textView in my app

        // This shit down here attaches a listener to this specific spinner so when it's selected
        // the main textView is changed. Which is the whole point.
        //TODO Fill in the basic Job description pages
        //TODO+Figure out how to have the 2nd Spinner change the 3rd Spinner.+
        //TODO+Figure out how to match corresponding Spinnenrs with the right descriptions.+
        //TODO+Fuck it just make a huge switch selector function. Get rid of that outdated to String shit.+
        //TODO+when you change the first two spinners they change the lower spinners, but not the TextView.+
        //TODO add an if statements to distinguish from the different codebases for the spinners and textviews.
        // Such that if I pick Paradise, Guides, then Science, it gives me the correct description on textView. Fuck this is hard.

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //myjavatextview.setText(parent.getItemAtPosition(position).toString());
                //selector[0] = position;
                //window = String.valueOf(selector[0]) + String.valueOf(selector[1]) + String.valueOf(selector[2]);
                //myjavatextview.setText(window);
                spin1 = parent.getItemAtPosition(position).toString();
                setSpinner1(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dropdown1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //myjavatextview.setText(String.valueOf(position));
                //selector[1] = position;
                //window = String.valueOf(selector[0]) + String.valueOf(selector[1]) + String.valueOf(selector[2]);
                //myjavatextview.setText(window);
                spin2 = parent.getItemAtPosition(position).toString();
                spinsum12 = spin1 + spin2;
                setSpinner2(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //myjavatextview.setText(parent.getItemAtPosition(position).toString());
                //selector[2] = position;
                //window = String.valueOf(selector[0]) + String.valueOf(selector[1]) + String.valueOf(selector[2]);
                //myjavatextview.setText(window);
                //myjavatextview.setText(getString(R.string.Captain));
                spin3 = parent.getItemAtPosition(position).toString();
                spinsum123 = spin1 + spin2 + spin3;
                setTheText(spin3);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void setSelector(int[] selector) {
        this.selector = selector;
    }

    public void setSpinner1(String item)
    {
        ArrayAdapter<CharSequence> adapter1;
        switch (spin1)
        {
            case "Paradise":
                dropdown1 = (Spinner)findViewById(R.id.spinner1);
                adapter1 = ArrayAdapter.createFromResource(this, R.array.Paradise, android.R.layout.simple_spinner_item);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dropdown1.setAdapter(adapter1);
                break;
            default:
                dropdown1 = (Spinner)findViewById(R.id.spinner1);
                adapter1 = ArrayAdapter.createFromResource(this, R.array.make_a_choice, android.R.layout.simple_spinner_item);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dropdown1.setAdapter(adapter1);
                break;
        }
    }

    public void setSpinner2(String item)
    {
        ArrayAdapter<CharSequence> adapter2;
        switch (spinsum12)
        {
            case "ParadiseJobs and Roles":
                dropdown2 = (Spinner)findViewById(R.id.spinner2);
                adapter2 = ArrayAdapter.createFromResource(this, R.array.ParadiseJobs, android.R.layout.simple_spinner_item);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dropdown2.setAdapter(adapter2);
                break;
            case "ParadiseGamemodes":
                dropdown2 = (Spinner)findViewById(R.id.spinner2);
                adapter2 = ArrayAdapter.createFromResource(this, R.array.Gamemodes, android.R.layout.simple_spinner_item);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dropdown2.setAdapter(adapter2);
                break;
            case "ParadiseSpecies":
                dropdown2 = (Spinner)findViewById(R.id.spinner2);
                adapter2 = ArrayAdapter.createFromResource(this, R.array.ParadiseSpecies, android.R.layout.simple_spinner_item);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dropdown2.setAdapter(adapter2);
                break;
            case "ParadiseChemistry":
                dropdown2 = (Spinner)findViewById(R.id.spinner2);
                adapter2 = ArrayAdapter.createFromResource(this, R.array.ParadiseChemistry, android.R.layout.simple_spinner_item);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dropdown2.setAdapter(adapter2);
                break;
            case "ParadiseConstruction":
                dropdown2 = (Spinner)findViewById(R.id.spinner2);
                adapter2 = ArrayAdapter.createFromResource(this, R.array.ParadiseConstruction, android.R.layout.simple_spinner_item);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dropdown2.setAdapter(adapter2);
                break;
            case "ParadiseHacking":
                dropdown2 = (Spinner)findViewById(R.id.spinner2);
                adapter2 = ArrayAdapter.createFromResource(this, R.array.ParadiseHacking, android.R.layout.simple_spinner_item);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dropdown2.setAdapter(adapter2);
                break;
            default:
                dropdown2 = (Spinner)findViewById(R.id.spinner2);
                adapter2 = ArrayAdapter.createFromResource(this, R.array.make_a_choice, android.R.layout.simple_spinner_item);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dropdown2.setAdapter(adapter2);
                break;
        }
    }

    public void setTheText(String item)
    {
        switch (spinsum123)
        {
            case "ParadiseSpeciesHumans":
                myjavatextview.setText(R.string.ParadiseSpeciesHumans);
                break;
            case "ParadiseSpeciesTajaran":
                myjavatextview.setText(R.string.ParadiseSpeciesTajaran);
                break;
            case "ParadiseSpeciesUnathi":
                myjavatextview.setText(R.string.ParadiseSpeciesUnathi);
                break;
            case "ParadiseSpeciesSkrell":
                myjavatextview.setText(R.string.ParadiseSpeciesSkrell);
                break;
            case "ParadiseSpeciesSlime People":
                myjavatextview.setText(R.string.ParadiseSpeciesSlime_People);
                break;
            case "ParadiseSpeciesVox":
                myjavatextview.setText(R.string.ParadiseSpeciesVox);
                break;
            case "ParadiseSpeciesGrey":
                myjavatextview.setText(R.string.ParadiseSpeciesGrey);
                break;
            case "ParadiseSpeciesDiona":
                myjavatextview.setText(R.string.ParadiseSpeciesDiona);
                break;
            case "ParadiseSpeciesMachine People":
                myjavatextview.setText(R.string.ParadiseSpeciesMachine_People);
                break;
            case "ParadiseSpeciesKidan":
                myjavatextview.setText(R.string.ParadiseSpeciesKidan);
                break;
            case "ParadiseSpeciesShadow people":
                myjavatextview.setText(R.string.ParadiseSpeciesShadow_people);
                break;
            case "ParadiseSpeciesPlasmamen":
                myjavatextview.setText(R.string.ParadiseSpeciesPlasmamen);
                break;
            case "ParadiseSpeciesVulpkanin":
                myjavatextview.setText(R.string.ParadiseSpeciesVulpkanin);
                break;
            case "ParadiseSpeciesDrask":
                myjavatextview.setText(R.string.ParadiseSpeciesDrask);
                break;
            case "ParadiseSpeciesPossible Candidates":
                myjavatextview.setText(R.string.ParadiseSpeciesPossible_Candidates);
                break;
            case "ParadiseSpeciesWryn":
                myjavatextview.setText(R.string.ParadiseSpeciesWryn);
                break;
            case "ParadiseSpeciesNucleation":
                myjavatextview.setText(R.string.ParadiseSpeciesNucleation);
                break;
            case "ParadiseJobs and RolesCaptain":
                myjavatextview.setText(R.string.ParadiseJobsCaptain);
                break;
            case "ParadiseJobs and RolesHead of Personnel":
                myjavatextview.setText(R.string.ParadiseJobsHOP);
                break;
            case "ParadiseJobs and RolesHead of Security":
                myjavatextview.setText(R.string.ParadiseJobsHOS);
                break;
            case "ParadiseJobs and RolesChief Engineer":
                myjavatextview.setText(R.string.ParadiseJobsCE);
                break;
            case "ParadiseJobs and RolesResearch Director":
                myjavatextview.setText(R.string.ParadiseJobsRD);
                break;
            case "ParadiseJobs and RolesChief Medical Officer":
                myjavatextview.setText(R.string.ParadiseJobsCMO);
                break;
            case "ParadiseJobs and RolesNanotrasen Representative":
                myjavatextview.setText(R.string.ParadiseJobsNR);
                break;
            case "ParadiseJobs and RolesMagistrate":
                myjavatextview.setText(R.string.ParadiseJobsMagistrate);
                break;
            case "ParadiseJobs and RolesBlueshield Officer":
                myjavatextview.setText(R.string.ParadiseJobsBO);
                break;
            case "ParadiseJobs and RolesWarden":
                myjavatextview.setText(R.string.ParadiseJobsWarden);
                break;
            case "ParadiseJobs and RolesSecurity Officer":
                myjavatextview.setText(R.string.ParadiseJobsSO);
                break;
            case "ParadiseJobs and RolesSecurity Pod Pilot":
                myjavatextview.setText(R.string.ParadiseJobsSPP);
                break;
            case "ParadiseJobs and RolesDetective":
                myjavatextview.setText(R.string.ParadiseJobsDetective);
                break;
            case "ParadiseJobs and RolesInternal Affairs":
                myjavatextview.setText(R.string.ParadiseJobsIA);
                break;
            case "ParadiseJobs and RolesBrig Physician":
                myjavatextview.setText(R.string.ParadiseJobsBP);
                break;
            case "ParadiseJobs and RolesStation Engineer":
                myjavatextview.setText(R.string.ParadiseJobsEngineer);
                break;
            case "ParadiseJobs and RolesMechanic":
                myjavatextview.setText(R.string.ParadiseJobsMechanic);
                break;
            case "ParadiseJobs and RolesAtmospheric Technician":
                myjavatextview.setText(R.string.ParadiseJobsAT);
                break;
            case "ParadiseJobs and RolesMedical Doctor":
                myjavatextview.setText(R.string.ParadiseJobsMD);
                break;
            case "ParadiseJobs and RolesParamedic":
                myjavatextview.setText(R.string.ParadiseJobsParamedic);
                break;
            case "ParadiseJobs and RolesChemist":
                myjavatextview.setText(R.string.ParadiseJobsChemist);
                break;
            case "ParadiseJobs and RolesGeneticist":
                myjavatextview.setText(R.string.ParadiseJobsGeneticist);
                break;
            case "ParadiseJobs and RolesVirologist":
                myjavatextview.setText(R.string.ParadiseJobsVirologist);
                break;
            case "ParadiseJobs and RolesPsychologist":
                myjavatextview.setText(R.string.ParadiseJobsPsychologist);
                break;
            case "ParadiseJobs and RolesScientist":
                myjavatextview.setText(R.string.ParadiseJobsScientist);
                break;
            case "ParadiseJobs and RolesRoboticist":
                myjavatextview.setText(R.string.ParadiseJobsRoboticist);
                break;
            case "ParadiseJobs and RolesXenobiologist":
                myjavatextview.setText(R.string.ParadiseJobsXenobiologist);
                break;
            case "ParadiseJobs and RolesQuartermaster":
                myjavatextview.setText(R.string.ParadiseJobsQuartermaster);
                break;
            case "ParadiseJobs and RolesCargo Technician":
                myjavatextview.setText(R.string.ParadiseJobsCT);
                break;
            case "ParadiseJobs and RolesShaft Miner":
                myjavatextview.setText(R.string.ParadiseJobsSM);
                break;
            case "ParadiseJobs and RolesJanitor":
                myjavatextview.setText(R.string.ParadiseJobsJanitor);
                break;
            case "ParadiseJobs and RolesChef":
                myjavatextview.setText(R.string.ParadiseJobsChef);
                break;
            case "ParadiseJobs and RolesBartender":
                myjavatextview.setText(R.string.ParadiseJobsBartender);
                break;
            case "ParadiseJobs and RolesBotanist":
                myjavatextview.setText(R.string.ParadiseJobsBotanist);
                break;
            case "ParadiseJobs and RolesBarber":
                myjavatextview.setText(R.string.ParadiseJobsBarber);
                break;
            case "ParadiseJobs and RolesCivilian":
                myjavatextview.setText(R.string.ParadiseJobsCivilian);
                break;
            case "ParadiseJobs and RolesClown":
                myjavatextview.setText(R.string.ParadiseJobsClown);
                break;
            case "ParadiseJobs and RolesMime":
                myjavatextview.setText(R.string.ParadiseJobsMime);
                break;
            case "ParadiseJobs and RolesChaplain":
                myjavatextview.setText(R.string.ParadiseJobsChaplain);
                break;
            case "ParadiseJobs and RolesLibrarian":
                myjavatextview.setText(R.string.ParadiseJobsLibrarian);
                break;
            case "ParadiseJobs and RolesAI":
                myjavatextview.setText(R.string.ParadiseJobsAI);
                break;
            case "ParadiseJobs and RolesCyborg":
                myjavatextview.setText(R.string.ParadiseJobsCyborg);
                break;
            case "ParadiseJobs and RolesPersonal AI":
                myjavatextview.setText(R.string.ParadiseJobsPAI);
                break;
            case "ParadiseJobs and RolesGuardian":
                myjavatextview.setText(R.string.ParadiseJobsGuardian);
                break;
            case "ParadiseJobs and RolesIan":
                myjavatextview.setText(R.string.ParadiseJobsIan);
                break;
            case "ParadiseJobs and RolesGhost":
                myjavatextview.setText(R.string.ParadiseJobsGhost);
                break;
            case "ParadiseJobs and RolesMouse":
                myjavatextview.setText(R.string.ParadiseJobsMouse);
                break;
            case "ParadiseJobs and RolesSpider":
                myjavatextview.setText(R.string.ParadiseJobsSpider);
                break;
            case "ParadiseJobs and RolesSpace Carp":
                myjavatextview.setText(R.string.ParadiseJobsSC);
                break;
            case "ParadiseJobs and RolesConstruct":
                myjavatextview.setText(R.string.ParadiseJobsConstruct);
                break;
            case "ParadiseJobs and RolesTraitor":
                myjavatextview.setText(R.string.ParadiseJobsTraitor);
                break;
            case "ParadiseJobs and RolesChangeling":
                myjavatextview.setText(R.string.ParadiseJobsChangeling);
                break;
            case "ParadiseJobs and RolesNuclear Agent":
                myjavatextview.setText(R.string.ParadiseJobsNA);
                break;
            case "ParadiseJobs and RolesXenomorph":
                myjavatextview.setText(R.string.ParadiseJobsXenomorph);
                break;
            case "ParadiseJobs and RolesWizard":
                myjavatextview.setText(R.string.ParadiseJobsWizard);
                break;
            case "ParadiseJobs and RolesCultist":
                myjavatextview.setText(R.string.ParadiseJobsCultist);
                break;
            case "ParadiseJobs and RolesShadowling":
                myjavatextview.setText(R.string.ParadiseJobsShadowling);
                break;
            case "ParadiseJobs and RolesVampire":
                myjavatextview.setText(R.string.ParadiseJobsVampire);
                break;
            case "ParadiseJobs and RolesVox Raider":
                myjavatextview.setText(R.string.ParadiseJobsVR);
                break;
            case "ParadiseJobs and RolesCortical Borer":
                myjavatextview.setText(R.string.ParadiseJobsCB);
                break;
            case "ParadiseJobs and RolesRevenant":
                myjavatextview.setText(R.string.ParadiseJobsRevenant);
                break;
            case "ParadiseJobs and RolesBlob":
                myjavatextview.setText(R.string.ParadiseJobsBlob);
                break;
            case "ParadiseJobs and RolesStatue":
                myjavatextview.setText(R.string.ParadiseJobsStatue);
                break;
            case "ParadiseJobs and RolesAbductor":
                myjavatextview.setText(R.string.ParadiseJobsAbductor);
                break;
            case "ParadiseJobs and RolesEmergency Response Team":
                myjavatextview.setText(R.string.ParadiseJobsERT);
                break;
            case "ParadiseJobs and RolesDeath Commando":
                myjavatextview.setText(R.string.ParadiseJobsDC);
                break;
            case "ParadiseJobs and RolesSpace Ninja":
                myjavatextview.setText(R.string.ParadiseJobsSN);
                break;
            case "ParadiseJobs and RolesHonk Squad":
                myjavatextview.setText(R.string.ParadiseJobsHS);
                break;
            case "ParadiseJobs and RolesSuper Heroes":
                myjavatextview.setText(R.string.ParadiseJobsSH);
                break;
            case "GamemodesSecret":
                myjavatextview.setText(R.string.GamemodesSecret);
                break;
            case "GamemodesTraitor":
                myjavatextview.setText(R.string.GamemodesTraitor);
                break;
            case "GamemodesAuto Traitor":
                myjavatextview.setText(R.string.GamemodesAuto_Traitor);
                break;
            case "GamemodesChangeling":
                myjavatextview.setText(R.string.GamemodesChangeling);
                break;
            case "GamemodesVampire":
                myjavatextview.setText(R.string.GamemodesVampire);
                break;
            case "GamemodesShadowling":
                myjavatextview.setText(R.string.GamemodesShadowling);
                break;
            case "GamemodesTraitor and Changeling":
                myjavatextview.setText(R.string.GamemodesTraitor_and_Changeling);
                break;
            case "GamemodesTraitor and Vampire":
                myjavatextview.setText(R.string.GamemodesTraitor_and_Vampire);
                break;
            case "GamemodesNuclear Emergency":
                myjavatextview.setText(R.string.GamemodesNuclear_Emergency);
                break;
            case "GamemodesBlob":
                myjavatextview.setText(R.string.GamemodesBlob);
                break;
            case "GamemodesCult":
                myjavatextview.setText(R.string.GamemodesCult);
                break;
            case "GamemodesWizard":
                myjavatextview.setText(R.string.GamemodesWizard);
                break;
            case "GamemodesExtended":
                myjavatextview.setText(R.string.GamemodesExtended);
                break;
            case "ParadiseChemistryComponents":
                myjavatextview.setText(R.string.ParadiseChemistryComponents);
                break;
            case "ParadiseChemistryAmmonia":
                myjavatextview.setText(R.string.ParadiseChemistryAmmonia);
                break;
            case "ParadiseChemistrySulphuric Acid":
                myjavatextview.setText(R.string.ParadiseChemistrySulphuric_Acid);
                break;
            case "ParadiseChemistryAsh":
                myjavatextview.setText(R.string.ParadiseChemistryAsh);
                break;
            case "ParadiseChemistryCarpet":
                myjavatextview.setText(R.string.ParadiseChemistryCarpet);
                break;
            case "ParadiseChemistryOil":
                myjavatextview.setText(R.string.ParadiseChemistryOil);
                break;
            case "ParadiseChemistryPhenol":
                myjavatextview.setText(R.string.ParadiseChemistryPhenol);
                break;
            case "ParadiseChemistryAcetone":
                myjavatextview.setText(R.string.ParadiseChemistryAcetone);
                break;
            case "ParadiseChemistryDiethylamine":
                myjavatextview.setText(R.string.ParadiseChemistryDiethylamine);
                break;
            case "ParadiseChemistrySaltpetre":
                myjavatextview.setText(R.string.ParadiseChemistrySaltpetre);
                break;
            case "ParadiseChemistryWelding Fuel":
                myjavatextview.setText(R.string.ParadiseChemistryWelding_Fuel);
                break;
            case "ParadiseChemistryCore Healing Medicines":
                myjavatextview.setText(R.string.ParadiseChemistryCore_Healing_Medicines);
                break;
            case "ParadiseChemistrySilver Sulfadiazine":
                myjavatextview.setText(R.string.ParadiseChemistrySilver_Sulfadiazine);
                break;
            case "ParadiseChemistryStyptic Powder":
                myjavatextview.setText(R.string.ParadiseChemistryStyptic_Powder);
                break;
            case "ParadiseChemistrySalineGlucose Solution":
                myjavatextview.setText(R.string.ParadiseChemistrySalineGlucose_Solution);
                break;
            case "ParadiseChemistrySynthflesh":
                myjavatextview.setText(R.string.ParadiseChemistrySynthflesh);
                break;
            case "ParadiseChemistryCharcoal":
                myjavatextview.setText(R.string.ParadiseChemistryCharcoal);
                break;
            case "ParadiseChemistrySalbutamol":
                myjavatextview.setText(R.string.ParadiseChemistrySalbutamol);
                break;
            case "ParadiseChemistryCryoxadone":
                myjavatextview.setText(R.string.ParadiseChemistryCryoxadone);
                break;
            case "ParadiseChemistrySynth Meat":
                myjavatextview.setText(R.string.ParadiseChemistrySynth_Meat);
                break;
            case "ParadiseChemistryMannitol":
                myjavatextview.setText(R.string.ParadiseChemistryMannitol);
                break;
            case "ParadiseChemistrySuperior Healing Medicines":
                myjavatextview.setText(R.string.ParadiseChemistrySuperior_Healing_Medicines);
                break;
            case "ParadiseChemistrySalicylic Acid":
                myjavatextview.setText(R.string.ParadiseChemistrySalicylic_Acid);
                break;
            case "ParadiseChemistryOmnizine":
                myjavatextview.setText(R.string.ParadiseChemistryOmnizine);
                break;
            case "ParadiseChemistryPentetic Acid":
                myjavatextview.setText(R.string.ParadiseChemistryPentetic_Acid);
                break;
            case "ParadiseChemistryPerfluorodecalin":
                myjavatextview.setText(R.string.ParadiseChemistryPerfluorodecalin);
                break;
            case "ParadiseChemistryAtropine":
                myjavatextview.setText(R.string.ParadiseChemistryAtropine);
                break;
            case "ParadiseChemistryCalomel":
                myjavatextview.setText(R.string.ParadiseChemistryCalomel);
                break;
            case "ParadiseChemistryMutadone":
                myjavatextview.setText(R.string.ParadiseChemistryMutadone);
                break;
            case "ParadiseChemistryUnique Healing Medicines":
                myjavatextview.setText(R.string.ParadiseChemistryUnique_Healing_Medicines);
                break;
            case "ParadiseChemistryPotassium Iodide":
                myjavatextview.setText(R.string.ParadiseChemistryPotassium_Iodide);
                break;
            case "ParadiseChemistryEphedrine":
                myjavatextview.setText(R.string.ParadiseChemistryEphedrine);
                break;
            case "ParadiseChemistryDiphenhydramine":
                myjavatextview.setText(R.string.ParadiseChemistryDiphenhydramine);
                break;
            case "ParadiseChemistryMorphine":
                myjavatextview.setText(R.string.ParadiseChemistryMorphine);
                break;
            case "ParadiseChemistryEther":
                myjavatextview.setText(R.string.ParadiseChemistryEther);
                break;
            case "ParadiseChemistryHydrocodone":
                myjavatextview.setText(R.string.ParadiseChemistryHydrocodone);
                break;
            case "ParadiseChemistryOculine":
                myjavatextview.setText(R.string.ParadiseChemistryOculine);
                break;
            case "ParadiseChemistryEpinephrine":
                myjavatextview.setText(R.string.ParadiseChemistryEpinephrine);
                break;
            case "ParadiseChemistryAntihol":
                myjavatextview.setText(R.string.ParadiseChemistryAntihol);
                break;
            case "ParadiseChemistryStimulants":
                myjavatextview.setText(R.string.ParadiseChemistryStimulants);
                break;
            case "ParadiseChemistryInsulin":
                myjavatextview.setText(R.string.ParadiseChemistryInsulin);
                break;
            case "ParadiseChemistrySpaceacillin":
                myjavatextview.setText(R.string.ParadiseChemistrySpaceacillin);
                break;
            case "ParadiseChemistryStrange Reagent":
                myjavatextview.setText(R.string.ParadiseChemistryStrange_Reagent);
                break;
            case "ParadiseChemistrySimethicone":
                myjavatextview.setText(R.string.ParadiseChemistrySimethicone);
                break;
            case "ParadiseChemistryTeporone":
                myjavatextview.setText(R.string.ParadiseChemistryTeporone);
                break;
            case "ParadiseChemistryHaloperidol":
                myjavatextview.setText(R.string.ParadiseChemistryHaloperidol);
                break;
            case "ParadiseChemistryRezadone":
                myjavatextview.setText(R.string.ParadiseChemistryRezadone);
                break;
            case "ParadiseChemistryMitocholide":
                myjavatextview.setText(R.string.ParadiseChemistryMitocholide);
                break;
            case "ParadiseChemistryLiquid Solder":
                myjavatextview.setText(R.string.ParadiseChemistryLiquid_Solder);
                break;
            case "ParadiseChemistryDegreaser":
                myjavatextview.setText(R.string.ParadiseChemistryDegreaser);
                break;
            case "ParadiseChemistryFliptonium":
                myjavatextview.setText(R.string.ParadiseChemistryFliptonium);
                break;
            case "ParadiseChemistryOther Chems":
                myjavatextview.setText(R.string.ParadiseChemistryOther_Chems);
                break;
            default:
                break;
            case "ParadiseConstructionFloor":
                myjavatextview.setText(R.string.ParadiseConstructionFloor);
                break;
            case "ParadiseConstructionLight Floor":
                myjavatextview.setText(R.string.ParadiseConstructionLight_Floor);
                break;
            case "ParadiseConstructionWalls":
                myjavatextview.setText(R.string.ParadiseConstructionWalls);
                break;
            case "ParadiseConstructionReinforced walls":
                myjavatextview.setText(R.string.ParadiseConstructionReinforced_walls);
                break;
            case "ParadiseConstructionGrille":
                myjavatextview.setText(R.string.ParadiseConstructionGrille);
                break;
            case "ParadiseConstructionGlass panels":
                myjavatextview.setText(R.string.ParadiseConstructionGlass_panels);
                break;
            case "ParadiseConstructionReinforced glass panels":
                myjavatextview.setText(R.string.ParadiseConstructionReinforced_glass_panels);
                break;
            case "ParadiseConstructionWindow-door":
                myjavatextview.setText(R.string.ParadiseConstructionWindowDoor);
                break;
            case "ParadiseConstructionHidden Door":
                myjavatextview.setText(R.string.ParadiseConstructionHidden_Door);
                break;
            case "ParadiseConstructionTable":
                myjavatextview.setText(R.string.ParadiseConstructionTable);
                break;
            case "ParadiseConstructionAPC":
                myjavatextview.setText(R.string.ParadiseConstructionAPC);
                break;
            case "ParadiseConstructionAir Alarm":
                myjavatextview.setText(R.string.ParadiseConstructionAir_Alarm);
                break;
            case "ParadiseConstructionIntercom Radio":
                myjavatextview.setText(R.string.ParadiseConstructionIntercom_Radio);
                break;
            case "ParadiseConstructionFire Alarm":
                myjavatextview.setText(R.string.ParadiseConstructionFire_Alarm);
                break;
            case "ParadiseConstructionAirlock":
                myjavatextview.setText(R.string.ParadiseConstructionAirlock);
                break;
            case "ParadiseConstructionComputers":
                myjavatextview.setText(R.string.ParadiseConstructionComputers);
                break;
            case "ParadiseConstructionAI Core":
                myjavatextview.setText(R.string.ParadiseConstructionAI_Core);
                break;
            case "ParadiseConstructionMachine":
                myjavatextview.setText(R.string.ParadiseConstructionMachine);
                break;
            case "ParadiseConstructionLight Fixture":
                myjavatextview.setText(R.string.ParadiseConstructionLight_Fixture);
                break;
            case "ParadiseConstructionSecurity Camera":
                myjavatextview.setText(R.string.ParadiseConstructionSecurity_Camera);
                break;
            case "ParadiseConstructionTurrets":
                myjavatextview.setText(R.string.ParadiseConstructionTurrets);
                break;
            case "ParadiseConstructionRecharge Station":
                myjavatextview.setText(R.string.ParadiseConstructionRecharge_Station);
                break;
            case "ParadiseConstructionFlamethrower":
                myjavatextview.setText(R.string.ParadiseConstructionFlamethrower);
                break;
            case "ParadiseConstructionDisposal Pipes and Machinery":
                myjavatextview.setText(R.string.ParadiseConstructionDisposal_Pipes_and_Machinery);
                break;
            case "ParadiseConstructionSolar Panels and Trackers":
                myjavatextview.setText(R.string.ParadiseConstructionSolar_Panels_and_Trackers);
                break;
            case "ParadiseConstructionBookcase":
                myjavatextview.setText(R.string.ParadiseConstructionBookcase);
                break;
            case "ParadiseConstructionLocker":
                myjavatextview.setText(R.string.ParadiseConstructionLocker);
                break;
            case "ParadiseConstructionDisplay Case":
                myjavatextview.setText(R.string.ParadiseConstructionDisplay_Case);
                break;
            case "ParadiseHackingWhat you will need":
                myjavatextview.setText(R.string.ParadiseHackingWhat_you_will_need);
                break;
            case "ParadiseHackingAirlocks":
                myjavatextview.setText(R.string.ParadiseHackingAirlocks);
                break;
            case "ParadiseHackingFinding the Right Wires With a Multitool":
                myjavatextview.setText(R.string.ParadiseHackingFinding_the_Right_Wires_With_a_Multitool);
                break;
            case "ParadiseHackingAirlock Wire Functions":
                myjavatextview.setText(R.string.ParadiseHackingAirlock_Wire_Functions);
                break;
            case "ParadiseHackingAPCs":
                myjavatextview.setText(R.string.ParadiseHackingAPCs);
                break;
            case "ParadiseHackingAtmos Alarms":
                myjavatextview.setText(R.string.ParadiseHackingAtmos_Alarms);
                break;
            case "ParadiseHackingAutolathes":
                myjavatextview.setText(R.string.ParadiseHackingAutolathes);
                break;
            case "ParadiseHackingMULEs":
                myjavatextview.setText(R.string.ParadiseHackingMULEs);
                break;
            case "ParadiseHackingCameras":
                myjavatextview.setText(R.string.ParadiseHackingCameras);
                break;
            case "ParadiseHackingParticle Accelerator":
                myjavatextview.setText(R.string.ParadiseHackingParticle_Accelerator);
                break;
            case "ParadiseHackingSyndicate Bomb":
                myjavatextview.setText(R.string.ParadiseHackingSyndicate_Bomb);
                break;
            case "ParadiseHackingLockboxes":
                myjavatextview.setText(R.string.ParadiseHackingLockboxes);
                break;
            case "ParadiseHackingSafes":
                myjavatextview.setText(R.string.ParadiseHackingSafes);
                break;
            case "ParadiseHackingMinor Hackables":
                myjavatextview.setText(R.string.ParadiseHackingMinor_Hackables);
                break;
            case "ParadiseHackingFire alarm":
                myjavatextview.setText(R.string.ParadiseHackingFire_alarm);
                break;
            case "ParadiseHackingSecurity Gasmask":
                myjavatextview.setText(R.string.ParadiseHackingSecurity_Gasmask);
                break;
            case "ParadiseHackingRadio and Signaler":
                myjavatextview.setText(R.string.ParadiseHackingRadio_and_Signaler);
                break;
            case "ParadiseHackingSecure Briefcase and Secure Safe":
                myjavatextview.setText(R.string.ParadiseHackingSecure_Briefcase_and_Secure_Safe);
                break;
            case "ParadiseHackingVending machines":
                myjavatextview.setText(R.string.ParadiseHackingVending_machines);
                break;
            case "ParadiseHackingChem Dispensers":
                myjavatextview.setText(R.string.ParadiseHackingChem_Dispensers);
                break;
        }

    }
}


