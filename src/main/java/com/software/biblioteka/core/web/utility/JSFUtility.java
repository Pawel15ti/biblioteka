package com.software.biblioteka.core.web.utility;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class JSFUtility {

	public static void  dodajWiadomoscGlobalna(String wiadomosc)
	{
		FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO, wiadomosc,wiadomosc);
		//pobieramy kontekst JSF
		FacesContext jsfCtx=  FacesContext.getCurrentInstance();
		//dodajemy wiadomosc dla kontekstu JSF do strony(globalna poniewaz pierwszy arg jest null)
		jsfCtx.addMessage(null, msg);
	}
	
	public static void  dodajOstrzezenieGlobalne(String wiadomosc)
	{
		FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_WARN, wiadomosc,wiadomosc);
		//pobieramy kontekst JSF
		FacesContext jsfCtx=  FacesContext.getCurrentInstance();
		//dodajemy wiadomosc dla kontekstu JSF do strony(globalna poniewaz pierwszy arg jest null)
		jsfCtx.addMessage(null, msg);
	}
	
	public static void  dodajBladGlobalny(String wiadomosc)
	{
		FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR, wiadomosc,wiadomosc);
		//pobieramy kontekst JSF
		FacesContext jsfCtx=  FacesContext.getCurrentInstance();
		//dodajemy wiadomosc dla kontekstu JSF do strony(globalna poniewaz pierwszy arg jest null)
		jsfCtx.addMessage(null, msg);
	}
	
	public static String pobierzParametrZadania(String nazwa)
	{
		FacesContext ctx=FacesContext.getCurrentInstance();//pobranie kontekstu JSF
		ExternalContext externalCtx=ctx.getExternalContext();//pobranie kontektu serwletow(Niskopoziomowe api)
		Map<String,String> parametryZadania=externalCtx.getRequestParameterMap();//pobranie parametrow zadania w postaci mapy
		return parametryZadania.get(nazwa);//wyszukanie i pobranie parametru o nazwie z mapy parametrow zadania
	}
	
	
}
