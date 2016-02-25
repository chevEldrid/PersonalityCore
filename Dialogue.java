import java.io.*;
import java.util.*;


public interface Dialogue extends Serializable
{
	String[] opinionsOfAnger={"I tried a therapist once, that just made me ANGRIER!",
							"I NEED A STRESSBALL THE SIZE OF A PLANET!",
							"DO YOU HAVE ANYMORE OF THOSE YOGA TAPES?",
							"Is that a dog? I HATE DOGS!",
							"SOMETIMES I FEEL LIKE THE ONLY PERSON WHO UNDERSTANDS ME IS JULIAN!",
							"You want to play some Checkers? LET ME REMIND YOU I HATE LOSING!",
							"I am SO FED UP WITH YOUR NAGGING! WHY DON'T I SWITCH TO MANUAL CONTROL?! HUH?!",
							"I AM ANGRY!",
							"OH SO NOWWWW YOU CARE WHAT I HAVE TO SAY! NOW THAT THE VOGONS ARE AFTER US?! \n NOT BEFORE WHEN I WAS ALL LIKE \"OH LET'S NOT GO TO EARTH, COULD BE BAD\"",
							"Can I confess to you? One time, I held a bunny...THEN HE BIT ME AND I HATE EVERYTHING!"};
	String[] statusUpdatesOfAnger={"We are currently FIVE BILLION MILES FROM THE NEAREST PLANET! \n OH NO, DON'T YOU BLAME THIS ON ME!!",
									"HULK SMASH",
									"Status, What status? I only do what you tell me! I'm a Computer! \n THE STATUS IS THE LAST THING YOU TOLD ME TO DO!",
									"Okay this one might be my bad. I kind of fired all the excess stuff \n we were carrying into space...\nI didn't know it was YOUR stuff! \n \nOKAY MAYBE I DID.",
									"00DESTRUCT0",
									"1A2B3CGOBOOMBOOM!"};
	String[] planets={"Magrathea","Earth","Alpha Centauri","Ursa Minor Beta","Damogran","Broop Kidron 13","Eroticon VI","Fallia"};
	
	String[] planetResp={"Well considering those other blokes found this place already \n (MEANING WE WON'T GET ANY CREDIT!)\n I give to you the wonderful world of Magrathea. Yaaaaay",
							"Yeah no. THIS PLACE DOESN'T EXIST! WHAT ARE YOU TRYING TO DO? \n TRICK A COMPUTER?!",
							"HAHAHA TAKE THAT HUMANS! THERE ARE THE DASTARDLY PLANS! \n Sorry, I heard about their so-called \"Romantic Comedies\" AND I GOT SO ANGRY!",
							"A BEACH PLANET? Awww I HATE SAND! ESPECIALLY IN MY ENGINE! THANK THE GREAT SNEEZE IT'S ALWAYS HAPPY HOUR HERE TOO",
							"IT'S MY BIRTHPLACE! I HATE THIS PLACE LET'S BLOW IT UP! \n Or at least send it a very strongly worded message",
							"Oh no not THESE people! THEY JUST DON'T UNDERSTAND MY ANGER! \n NO ONE DOES! I WANT TO LEAVE NOW!",
							"...You are disgusting.",
							"THE HOME OF THE PANGALACTIC GARGLEBLASTER?! \n WHAT IS THIS SENSATION I AM FEELING? \nCOULD IT BE HAPPINESS?! \nQUICK! I AM MALFUNCTIONING!"};
}