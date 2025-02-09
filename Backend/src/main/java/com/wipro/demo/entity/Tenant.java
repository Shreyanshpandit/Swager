package com.wipro.demo.entity;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Tenant {

	@Schema(description = "The unique ID of the tenant", example = "9")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tenant_id;

	@Schema(description = "The username of the tenant", example = "tenant123")
	@NotNull
	@Column(unique = true)
	private String username;

	@Schema(description = "The password of the tenant", example = "1234567890")
	@NotNull
	private String password;

	@NotNull
	@Schema(description = "The first name of the tenant", example = "John")
	private String first_name;

	@NotNull
	 @Schema(description = "The last name of the tenant", example = "Doe")
	private String last_name;

	@NotNull
	@Schema(description = "The mobile number of the tenant", example = "1308950049")
	@Pattern(regexp = "\\d{10}", message = "Mobile number should be 10 digits")
	private String mobile;

	@NotNull
	@Min(value = 18, message = "Age should be >= 18")
	@Schema(description = "The age of the tenant", example = "18")
	private Integer age;

	@NotNull
	 @Schema(description = "The status of the tenant", example = "Active")
	private String status;// (PENDING, APPROVED, REJECTED)

	@NotNull
	@Schema(description = "Whether the tenant is blocked", example = "true")
	private Boolean blocked;

	@OneToOne
	@JoinColumn(name = "flat_id")
	@Schema(description = "The flat rented by the tenant")
	private Flat flat;

	@OneToMany(mappedBy = "tenant")
	 @Schema(description = "The bookings made by the tenant")
	private List<Booking> bookings;

	public Tenant() {
	}

	public Tenant(Integer tenant_id, @NotNull String username, @NotNull String password, @NotNull String first_name,
			@NotNull String last_name,
			@NotNull @Pattern(regexp = "\\d{10}", message = "Mobile number should be 10 digits") String mobile,
			@NotNull @Min(value = 18, message = "Age should be >= 18") Integer age, @NotNull String status,
			@NotNull Boolean blocked, Flat flat, List<Booking> bookings) {
		super();
		this.tenant_id = tenant_id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile = mobile;
		this.age = age;
		this.status = status;
		this.blocked = blocked;
		this.flat = flat;
		this.bookings = bookings;
	}

	public Integer getTenant_id() {
		return tenant_id;
	}

	public void setTenant_id(Integer tenant_id) {
		this.tenant_id = tenant_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	public Flat getFlat() {
		return flat;
	}

	public void setFlat(Flat flat) {
		this.flat = flat;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

}
