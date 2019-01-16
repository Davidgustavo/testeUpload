!function(o) {
	function e(o) {
		var e = [].slice.call(arguments, 1), a = 0;
		return o.replace(/%s/g, function() {
			return e[a++]
		})
	}
			angular
					.module("upload.services", [])
					.service(
							"UploadService",
							[
									"$http",
									"$compile",
									"$modal",
									"Upload",
									function(o, e, a, t) {
										var n = $("body");
										angular.element(n.get(0)).scope();
										this.upload = function(o) {
											a
													.open({
														templateUrl : "plugins/cronapp-framework-js/components/upload/upload.html",
														controller : "UploadController",
														resolve : {
															data : function() {
																return o
															}
														}
													})
										}.bind(this)
									}]),
			angular
					.module("custom.controllers")
					.controller(
							"UploadController",
							[
									"$scope",
									"$http",
									"$translate",
									"$stateParams",
									"$location",
									"$http",
									"$modalInstance",
									"data",
									function(o, a, t, n, r, a, l, i) {
										app.registerEventsCronapi(o, t),
												o.params = n, o.$http = a;
										var s = r.search();
										for ( var p in s)
											s.hasOwnProperty(p)
													&& (o.params[p] = s[p]);
												o.files = [],
												o.uploading = !1,
												o.uploaded = !0,
												o.progress = 0,
												o.data = i,
												o.message = t
														.instant("Upload.oneFile"),
												"true" == i.multiple
														&& (o.message = t
																.instant("Upload.multipleFile")),
												i.description
														&& (o.message = i.description),
												o.safeApply = safeApply,
												o.uploadFile = function(n) {
													var r = o.data.scope, l = "api/cronapi/upload/"
															+ i.id, s = new FormData;
													if (0 == n.length)
														this.Notification
																.error(e(
																		t
																				.instant("Upload.errorValidation"),
																		i.maxSize,
																		i.filter));
													else {
														for (var p = 0; p < n.length; p++)
																	s
																			.append(
																					"file",
																					n[p]),
																	console
																			.log(n[p].$valid);
														var d = JSON
																.parse(localStorage
																		.getItem("_u"));
														this.$promise = a(
																{
																	method : "POST",
																	url : (window.hostApp || "")
																			+ l,
																	data : s,
																	headers : {
																		"Content-Type" : void 0,
																		"X-AUTH-TOKEN" : d.token
																	},
																	onProgress : function(
																			e) {
																		this
																				.safeApply(function() {
																					if (e.lengthComputable) {
																						var a = e.loaded
																								/ e.total
																								* 100
																								| 0;
																						o.progress = a
																					}
																							o.uploading = !0,
																							console
																									.log(a)
																				})
																	}
																			.bind(this)
																})
																.success(
																		function(
																				e,
																				a,
																				t,
																				n) {
																			r.cronapi
																					.evalInContext(JSON
																							.stringify(e));
																					o.uploaded = !0,
																					o.uploading = !1,
																					o
																							.close()
																		}
																				.bind(this))
																.error(
																		function(
																				e,
																				a,
																				t) {
																					this.Notification
																							.error(e.error),
																					o.uploading = !1,
																					o
																							.close()
																		}
																				.bind(this))
													}
												}.bind(o),
												o.close = function() {
													l.dismiss("cancel")
												}
									}])
}(app);