var app = app || {};

(function($){
    /*
     * Model definitions
     */
    var UserModel = Backbone.Model.extend({idAttribute: 'userId'});
    var EventModel = Backbone.Model.extend({});

    /*
     * Collection Model definitions
     */
    var UserCollection = Backbone.Collection.extend({
        model: UserModel,
        url: '/spontan/rest/user',

        initialize: function() {
            this.on('remove', this.hideModel);
        },
        hideModel: function() {
            this.model.trigger('hide');
        }
    });

    var EventCollection = Backbone.Collection.extend({
        model: EventModel,
        url: '/spontan/rest/event'
    });

    /*
     * Single Element View definitions
     */
    var TinyUserView = Backbone.View.extend({
        tagName: 'li',
        className: 'list-group-item',
        template: _.template('<%= firstname %> <em>(<%= nickname%>)</em> <%= lastname %>'),

        initialize: function(){
            this.model.on('change', this.render, this);
            this.model.on('hide', this.remove, this);
        },
        render: function() {
            var attributes = this.model.toJSON();
            this.$el.html(this.template(attributes));
            return this;
        }
    });

    var TinyEventView = Backbone.View.extend({
        tagName: 'li',
        className: 'list-group-item',
        template: _.template('<span class="badge"><%= participantIds.length%></span><em><%= date%></em> <%= motto%>'),

        initialize: function() {
            this.model.on('change', this.render, this);
            this.model.on('hide', this.remove, this);
        },
        render: function() {
            var attributes = this.model.toJSON();
            this.$el.html(this.template(attributes));
            return this;
        }
    });

    /*
     * Collection View definitions
     */
    var UserList = Backbone.View.extend({
        tagName: 'ul',
        className: 'list-group',

        initialize: function(){
            this.collection.on('add', this.addOne, this);
            this.collection.on('reset', this.addAll, this);
            this.collection.on('fetch', this.addAll, this);
        },
        addAll: function(){
            this.collection.forEach(this.addOne, this);
        },
        addOne: function(user) {
            var userView = new TinyUserView({model: user});
            this.$el.append(userView.render().el);
        },
        render: function(){
            this.addAll();
        }
    });

    var EventList = Backbone.View.extend({
        tagName: 'ul',
        className: 'list-group',

        initialize: function() {
            this.collection.on('add', this.addOne, this);
            this.collection.on('reset', this.addAll, this);
            this.collection.on('fetch', this.addAll, this);
        },
        addAll: function() {
            this.collection.forEach(this.addOne, this);
        },
        addOne: function (event) {
            var eventView = new TinyEventView({model: event});
            this.$el.append(eventView.render().el);
        },
        render: function () {
            this.addAll();
        }

    });


    /*
     * Router definitions
     */
    var AppRouter = Backbone.Router.extend({
        routes: {"/*" : 'index'},
        initialize: function() {
            this.users = new UserCollection();
            this.userListView = new UserList({collection: this.users});
            this.events = new EventCollection();
            this.eventListView = new EventList({collection: this.events});

            $('#usersList').append(this.userListView.el);
            $('#my_events').append(this.eventListView.el);
        },
        start: function() {
            Backbone.history.start({pushState: true});
        },
        index: function() {
            this.users.fetch();
            this.events.fetch();
        }
    });

    app = new AppRouter();

    var users = new UserCollection();
    var userListView = new UserList({collection: users});
    $('#usersList').append(userListView.el);
    users.fetch();

})(jQuery)