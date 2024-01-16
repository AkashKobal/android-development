public class medaiplayer {
    
}
////////////// Media Player
    Button btnPause, btnPlay, btnStop;

    @Override
        btnPause = findViewById(R.id.btnPause);
        btnPlay = findViewById(R.id.btnPlay);
        btnStop = findViewById(R.id.btnStop);

        MediaPlayer mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        String aPath = "android.resource://"+getPackageName()+"/raw/song2";

        String onlineAudioPath = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";
       Uri audioURI = Uri.parse(aPath);

        try{
            mp.setDataSource(this,audioURI);
            mp.prepare();

        }
        catch (Exception e){

        }

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();

            }
        });


        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();

            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause(); 
                mp.seekTo(0); 

            }
        });

        //mp.seekTo(0); // play the audio from from where ever we want to satrt
//        mp.getDuration() to skip the song with specific seconds
//        mp.getCurrentPosition();

//        setOnCompletionListener is used when the song is finished and we want to play next song.
       /* mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {


            }
        });*/

    }}
