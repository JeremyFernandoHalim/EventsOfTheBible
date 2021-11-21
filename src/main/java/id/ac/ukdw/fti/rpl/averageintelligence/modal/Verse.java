package id.ac.ukdw.fti.rpl.averageintelligence.modal;

public class Verse {
    private String titleEvents;
    private Integer dateEvents;
    private String durationEvents;
    private String ayatEvents;

    public void setAyatEvents(String ayatEvents){
        this.ayatEvents = ayatEvents;
    }

    public void setTitleEvents(String titleEvents){
        this.titleEvents = titleEvents;
    }

    public void setDateEvents(int dateEvents){
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

    public Integer getDateEvents(){
        if(Integer.toString(this.dateEvents)==null) {
            return 0;
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
