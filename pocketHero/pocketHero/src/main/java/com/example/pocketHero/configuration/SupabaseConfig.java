import io.supabase.PostgrestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupabaseConfig {
//DEPRECATED UNTIL I FIND A WAY TO SEND JPA TO SUPABASE
    @Bean
    public PostgrestClient supabaseClient() {
        return new PostgrestClient("postgres://postgres.qiossybpivpciokguinp:Goblinsarereal2024@aws-0-eu-central-1.pooler.supabase.com:6543/postgres");
    }
}