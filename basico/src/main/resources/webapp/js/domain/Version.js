function Version() {
    this.version;
    this.dateUploaded;
    this.devicesForEachVersion;
    this.totalDevices;
    this.url;
    this.news;

    this.setVersion = function(version) {
        this.version = version;
    }

    this.getVersion = function() {
        return this.version;
    }

    this.setDateUploaded = function(dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    this.getDateUploaded = function() {
        return this.dateUploaded;
    }

    this.setDevicesForEachVersion = function(devicesForEachVersion) {
        this.devicesForEachVersion = devicesForEachVersion;
    }

    this.getDevicesForEachVersion = function() {
        return this.devicesForEachVersion;
    }

    this.setTotalDevices = function(totalDevices) {
        this.totalDevices = totalDevices;
    }

    this.getTotalDevices = function() {
        return this.totalDevices;
    }

    this.setUrl = function(url) {
        this.url = url;
    }

    this.getUrl = function() {
        return this.url;
    }

    this.setNews = function(news) {
        this.news = news;
    }

    this.getNews = function() {
        return this.news;
    }

}
