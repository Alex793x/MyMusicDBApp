package com.example.mymusicdemo.controller;

import com.example.mymusicdemo.model.Albums;
import com.example.mymusicdemo.model.Artists;
import com.example.mymusicdemo.model.RecordCompanies;
import com.example.mymusicdemo.model.Tracks;
import com.example.mymusicdemo.service.AlbumsService;
import com.example.mymusicdemo.service.ArtistsService;
import com.example.mymusicdemo.service.RecordCompaniesService;
import com.example.mymusicdemo.service.TracksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {


    @Autowired
    RecordCompaniesService recordCompaniesService;
    @Autowired
    ArtistsService artistsService;
    @Autowired
    AlbumsService albumsService;
    @Autowired
    TracksService tracksService;


    /* Get different sides */
    @GetMapping("/")
    public String index(Model model) {
        List<Artists> artistsList = artistsService.fetchAll();
        model.addAttribute("artists", artistsList);
        return "home/index";
    }

    @GetMapping("/recordCompanies")
    public String recordCompanies(Model model) {
        List<RecordCompanies> recordCompaniesList = recordCompaniesService.fetchAll();
        model.addAttribute("record_companies", recordCompaniesList);
        return "home/record_companies";
    }

    @GetMapping("/albums")
    public String albums(Model model) {
        List<Albums> albumsList = albumsService.fetchAll();
        model.addAttribute("albums", albumsList);
        return "home/albums";
    }

    @GetMapping("/tracks")
    public String songs(Model model) {
        List<Tracks> tracksList = tracksService.fetchAll();
        model.addAttribute("tracks", tracksList);
        return "home/tracks";
    }


    /* Create methods */
    @GetMapping("/createAll")
    public String create() {
        return "home/create";
    }

    @PostMapping("/createNew")
    public String createNew(@ModelAttribute RecordCompanies recordCompanies,
                            @ModelAttribute Artists artists,
                            @ModelAttribute Albums albums,
                            @ModelAttribute Tracks tracks)
    {
        recordCompaniesService.addRecordCompany(recordCompanies);
        artistsService.addArtist(artists);
        albumsService.addAlbums(albums);
        tracksService.addTracks(tracks);
        return "redirect:/";
    }

    @GetMapping("/createArtist")
    public String createArtist() {
        return "home/createArtist";
    }

    @PostMapping("/addArtist")
    public String addArtist(@ModelAttribute Artists artists) {
        artistsService.addArtist(artists);
        return "redirect:/";
    }

    @GetMapping("/createRecordCompany")
    public String createRecordCompany() {
        return "home/createRecordCompany";
    }

    @PostMapping("/addRecordCompany")
    public String addRecordCompany(@ModelAttribute RecordCompanies recordCompanies) {
        recordCompaniesService.addRecordCompany(recordCompanies);
        return "home/record_companies";
    }

    @GetMapping("/createAlbum")
    public String createAlbum() {
        return "home/createAlbum";
    }

    @PostMapping("/addAlbum")
    public String addAlbum(@ModelAttribute Albums albums) {
        albumsService.addAlbums(albums);
        return "home/albums";
    }

    @GetMapping("createTrack")
    public String createTrack() {
        return "home/createTrack";
    }

    @PostMapping("/addTrack")
    public String addTrack(@ModelAttribute Tracks tracks) {
        tracksService.addTracks(tracks);
        return "home/tracks";
    }


    @GetMapping("/albumRecordCompany")
    public String albumRecordCompanies(@RequestParam("record_company_id") int record_company_id, Model model) {
        List<RecordCompanies> recordCompanies = recordCompaniesService.fetch_fk_all_albums(record_company_id);
        model.addAttribute("record_companies", recordCompanies);
        return "home/albumRecordCompany";
    }

    @GetMapping("/artistRecordCompany")
    public String artistRecordCompany(@RequestParam("record_company_id") int record_company_id, Model model) {
        List<RecordCompanies> recordCompanies = recordCompaniesService.fetch_fk_all_artists(record_company_id);
        model.addAttribute("record_companies", recordCompanies);
        return "home/artistRecordCompany";
    }

    @GetMapping("/artistAlbum")
    public String artistAlbum(@RequestParam("artist_id") int artist_id, Model model) {
        List<Albums> albumsList = albumsService.fetch_fk_all_artist(artist_id);
        model.addAttribute("albums", albumsList);
        return "home/artistAlbum";
    }

    @GetMapping("/artistSongs")
    public String artistSongs(@RequestParam("artists_id") int artists_id, Model model) {
        List<Tracks> tracksList = tracksService.fetch_fk_all_artists(artists_id);
        model.addAttribute("tracks", tracksList);
        return "home/artistSongs";
    }

    @GetMapping("/updateOneRecordCompany/{id}")
    public String updateOneRecordCompany(@PathVariable("id") int id, Model model) {
        model.addAttribute("record_company", recordCompaniesService.findRecordCompanyById(id));
        return "home/updateOneRecordCompany";
    }

    @PostMapping("/updateRecordCompany")
    public String updateRecordCompany(@ModelAttribute RecordCompanies recordCompanies) {
        recordCompaniesService.updateRecordCompany(recordCompanies.getRecord_company_id(), recordCompanies);
        return "redirect:/recordCompanies";
    }

    @GetMapping("/deleteOneRecordCompany/{id}")
    public String deleteRecordCompany(@PathVariable("id") int id) {
        recordCompaniesService.deleteRecordCompany(id);
        return "redirect:/recordCompanies";
    }


    @GetMapping("/albumsSongs/{id}")
    public String albumSongs(@PathVariable("id") int id, Model model) {
        List<Tracks> tracksList = tracksService.fetch_all_fk_albums(id);
        model.addAttribute("tracks", tracksList);
        return "home/albumsSongs";
    }

    @GetMapping("/deleteOneAlbum/{id}")
    public String deleteAlbum(@PathVariable("id") int id) {
        albumsService.deleteAlbum(id);
        return "redirect:/albums";
    }

    @GetMapping("/addNewSong/{id}")
    public String addOneNewSong(@PathVariable("id") int id, Model model) {
        model.addAttribute("albums", albumsService.findAlbumById(id));
        return "home/addNewSong";
    }

    @PostMapping("/addNewSong")
    public String addNewSong(@ModelAttribute Tracks tracks) {
        tracksService.addTracks(tracks);
        return "redirect:/albums";
    }
}
