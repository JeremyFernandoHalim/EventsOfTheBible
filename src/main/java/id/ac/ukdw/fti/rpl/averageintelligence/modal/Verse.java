package id.ac.ukdw.fti.rpl.averageintelligence.modal;

public class Verse {
    private String ayatEvents;
    private String titleEvents;
    private String dateEvents;
    private String durationEvents;

    public void setAyatEvents(String ayatEvents){
        this.ayatEvents = ayatEvents;
    }

    public void setTitleEvents(String titleEvents){
        this.titleEvents = titleEvents;
    }

    public void setDateEvents(String dateEvents){
        this.dateEvents = dateEvents;
    }

    public void setDurationEvents(String durationEvents){
        this.durationEvents = durationEvents;
    }

    public String getAyatEvents(){
        if(this.ayatEvents==null){
            return "null";
        }else{
            return this.ayatEvents;
        }
    }

    public String getTitleEvents(){
        if(this.titleEvents==null){
            return "null";
        }else{
            return this.titleEvents;
        }  
    }

    public String getDateEvents(){
        if(this.dateEvents==null){
            return "null";
        }else{
            return this.dateEvents;
        }   
    }

    public String getDurationEvents(){
        if(this.durationEvents==null){
            return "null";
        }else{
            return this.durationEvents;
        }   
    }
  
}
